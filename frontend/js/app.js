  function getDepartamentos(){
   return fetch("http://localhost:8080/departamentos").then(response=>response.json())
  }

  function renderDepartamentos(lista){
    const contenedor= document.getElementById("lista");

    lista.forEach(depto => {
      contenedor.innerHTML += `
        <div>
          <h3>${depto.nombre}</h3>
          <p>${depto.descripcion}</p>
          <p>$${depto.precio}</p>

          <a href="detalle.html?id=${depto.id}">
           Ver detalle
          </a>
          <a href="reserva.html?id=${depto.id}">Reservar</a>
        </div>
        <hr>
      `;
    });
}
 
getDepartamentos().then(renderDepartamentos).catch(error => {
    console.error("Error:", error);
  }); ;
  
