const cuenta= document.getElementById("btnCuenta").addEventListener("click",crearUsuario());

function crearUsuario(e){
    e.preventDefault();

    const nombre= document.getElementById("Nombre").value();
    const apellido= document.getElementById("Apellido").value();
    const edad= document.getElementById("Edad").value();
    const email= document.getElementById("Email").value();
    const contraseña= document.getElementById("Contraseña").value();
    const rol= document.getElementById("Rol").value();

    const usuario={
        nombre:nombre,
        apellido:apellido,
        edad:edad,
        email:email,
        contraseña:contraseña,
        rol:rol
    }

    fetch("http://localhost:8081/usuarios", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(usuario)
  })
  .then(res => {
    if (!res.ok) {
      throw new Error("Error al crear usuario");
    }
    return res.json();
  })
  .then(data => {
    alert("Usuario creado con éxito!");

    // 🔥 lo guardás para usarlo después (reservas, etc)
    localStorage.setItem("usuario", JSON.stringify(data));

    // 👉 opcional: redirigir
    window.location.href = "index.html";
  })
  .catch(err => {
    console.error(err);
    alert("Error al registrarse (puede que el email ya exista)");
  });
};
