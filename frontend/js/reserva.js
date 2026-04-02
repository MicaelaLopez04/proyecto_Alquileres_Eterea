const reserva= document.getElementById("btnReserva").addEventListener("click",crearReserva());




function crearReserva(event){

event.preventDefault();

const params = new URLSearchParams(window.location.search);
const departamentoId = params.get("id");

const fechaInicio = document.getElementById("fechaInicio").value;
const fechaFin = document.getElementById("fechaFin").value;
const cantidadPersonas= document.getElementById("cantidadPersonas").value;
const descripcion= document.getElementById("descripcion").value;

const reserva={
    fechaInicio: fechaInicio,
    fechaFin:fechaFin,
    cantidadPersonas:cantidadPersonas,
    descripcion: descripcion,
    usuarioId:1,
    departamentoId: Number(departamentoId)
    
}

fetch("http://localhost:8082/reservas", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(reserva)
  })
  .then(res => {
    if (res.ok) {
      alert("Reserva creada!");
    } else {
      alert("Error al crear reserva");
    }
  })
  .catch(err => console.error(err));

}


