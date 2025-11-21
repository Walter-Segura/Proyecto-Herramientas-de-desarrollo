const api = "https://farmacia-backend-y367.onrender.com/api/clientes";

document.getElementById("formCliente").addEventListener("submit", async (e) => {
    e.preventDefault();

    const nombre = document.getElementById("nombre").value;
    const edad = document.getElementById("edad").value;

    await fetch(`${api}/agregar`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nombre, edad })
    });

    cargarClientes();
});

document.getElementById("btnAtender").addEventListener("click", async () => {
    // llamar al endpoint correcto
    await fetch(`${api}/atender`, { method: "POST" });
    cargarClientes();
});

async function cargarClientes() {
    const res = await fetch(`${api}/listar`);
    const data = await res.text(); // tu backend devuelve String
    document.getElementById("listaClientes").textContent = data;
}

// cargar de inicio
cargarClientes();
