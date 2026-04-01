const params = new URLSearchParams(window.location.search);
const id = params.get("id");

 
 function getDepartamento(id) {
  return fetch(`http://localhost:8080/departamentos/${id}`)
    .then(response => response.json());
}

function renderDepartamento(depto) {
  const contenedor = document.getElementById("detalle");

  contenedor.innerHTML = `
    <div>
      <h3>${depto.nombre}</h3>
      <p>${depto.descripcion}</p>
      <p>$${depto.precio}</p>

      <a href="reserva.html?id=${depto.id}">Reservar</a>
    </div>
  `;
}

getDepartamento(id).then(renderDepartamento);

