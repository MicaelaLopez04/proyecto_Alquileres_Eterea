const params = new URLSearchParams(window.location.search);
const id = params.get("id");

 
 function getDepartamento(id) {
  return fetch(`http://localhost:8080/departamentos/${id}`)
    .then(response => response.json());
}

function renderDepartamento(depto) {
  const contenedor = document.getElementById("detalle");

  contenedor.innerHTML = `
    <div class="card">
        <h3>${depto.nombre}</h3>
        <p class="desc">${depto.descripcion}</p>
        <p class="precio">$${depto.precio}</p>

        <div class="acciones">
          <a href="reserva.html?id=${depto.id}" class="btn secundario">Reservar</a>
        </div>
      </div>
  `;
}

getDepartamento(id).then(renderDepartamento);

