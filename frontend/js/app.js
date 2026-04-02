  function getDepartamentos(){
   return fetch("http://localhost:8080/departamentos").then(response=>response.json())
  }

function renderDepartamentos(lista){
  const contenedor = document.getElementById("lista");

  contenedor.innerHTML = ""; // limpia antes

  lista.forEach(depto => {
    contenedor.innerHTML += `
      <div class="card">
        <h3>${depto.nombre}</h3>
        <p class="desc">${depto.descripcion}</p>
        <p class="precio">$${depto.precio}</p>

        <div class="acciones">
          <a href="detalle.html?id=${depto.id}" class="btn">Ver detalle</a>
          <a href="reserva.html?id=${depto.id}" class="btn secundario">Reservar</a>
        </div>
      </div>
    `;
  });
}
 
getDepartamentos().then(renderDepartamentos).catch(error => {
    console.error("Error:", error);
  }); ;
  
