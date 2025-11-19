const inpNombre = document.getElementById('inpNombre');
  const inpApellidos = document.getElementById('inpApellidos');
  const btnEnviar = document.getElementById('btnEnviar');
  const btnListar = document.getElementById('btnListar');

// -------------------------------------------------------
//  REGISTRAR PACIENTE
// -------------------------------------------------------
document.getElementById('btnReg').addEventListener('click', async () => {
  try {
    const nombre = document.getElementById('nombre').value;
    const apellidos = document.getElementById('apellidos').value;
    const edad = Number(document.getElementById('edad').value || 0);
    const telefono = document.getElementById('telefono').value;

    const res = await fetch('http://localhost:8080/api/pacientes/registro', {
      method: 'POST',
      headers: {'Content-Type':'application/json'},
      body: JSON.stringify({ nombre, apellidos, edad, telefono })
    });

    const data = await res.json();
    document.getElementById('resReg').textContent = JSON.stringify(data, null, 2);
  } catch (e) {
    document.getElementById('resReg').textContent = 'Error: ' + e.message;
  }
});

// -------------------------------------------------------
//  SOLICITAR CITA
// -------------------------------------------------------
document.getElementById('btnCita').addEventListener('click', async () => {
  try {
    const pacienteId = Number(document.getElementById('idPaciente').value);
    const motivo = document.getElementById('motivo').value;
    const prioridad = document.getElementById('prioridad').value;

    // obtener paciente
    const pRes = await fetch('http://localhost:8080/api/pacientes/' + pacienteId);
    if (!pRes.ok) {
      document.getElementById('resCita').textContent = 'Paciente no encontrado';
      return;
    }

    const paciente = await pRes.json();

    const res = await fetch('http://localhost:8080/api/citas/solicitar', {
      method: 'POST',
      headers: {'Content-Type':'application/json'},
      body: JSON.stringify({ paciente, motivo, prioridad })
    });

    const data = await res.json();
    document.getElementById('resCita').textContent = JSON.stringify(data, null, 2);
  } catch (e) {
    document.getElementById('resCita').textContent = 'Error: ' + e.message;
  }
});

// -------------------------------------------------------
//  ATENDER SIGUIENTE CITA
// -------------------------------------------------------
document.getElementById('btnAtender').addEventListener('click', async () => {
  try {
    const res = await fetch('http://localhost:8080/api/citas/atender', {
      method: 'POST'
    });

    if (res.status === 204) {
      document.getElementById('resAtender').textContent = 'No hay citas';
      return;
    }

    const data = await res.json();
    document.getElementById('resAtender').textContent = JSON.stringify(data, null, 2);
  } catch (e) {
    document.getElementById('resAtender').textContent = 'Error: ' + e.message;
  }
});

// -------------------------------------------------------
//  ATENDER SIGUIENTE CITA
// -------------------------------------------------------
document.getElementById('btnListar').addEventListener('click', async () => {

  const respuesta = await fetch(
        'http://localhost:8080/api/persona',
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    )
  
  console.log(respuesta);
    const respuestaJson = await respuesta.json();
    console.log(respuestaJson);

    console.log("Claves reales de respuestaJson:", Object.keys(respuestaJson));

    const listaPersonas = respuestaJson.Paciente;

    let htmlTable = '';

    for (let i = 0; i < listaPersonas.length; i++) {
        const persona = listaPersonas[i];
        htmlTable += `
        <tr>
            <td>${i + 1}</td>
            <td>${persona.nombre}</td>
            <td>${persona.apellidos}</td>
        </tr>
    `;
    }
    bdTablePeople.innerHTML = htmlTable;
});

// -------------------------------------------------------
//  ACTIVAR LINK CORRESPONDIENTE SEGÚN LA URL
// -------------------------------------------------------

document.addEventListener("DOMContentLoaded", () => {
  const navLinks = document.querySelectorAll(".nav-link");

  const currentPage = window.location.pathname.split("/").pop();

  navLinks.forEach(link => {
    const linkPage = link.getAttribute("href");

    if (linkPage === currentPage) {
      link.classList.add("active");
      link.setAttribute("aria-current", "page");
    } else {
      link.classList.remove("active");
      link.removeAttribute("aria-current");
    }
  });
});