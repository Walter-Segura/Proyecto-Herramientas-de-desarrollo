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

    document.getElementById("formCliente").reset();
    cargarClientes();
});

document.getElementById("btnAtender").addEventListener("click", async () => {
    await fetch(`${api}/atender`, { method: "POST" });
    cargarClientes();
});

async function cargarClientes() {
    const res = await fetch(`${api}/listar`);
    const clientes = await res.json(); // ahora sí JSON

    const tbody = document.querySelector("#tablaClientes tbody");
    tbody.innerHTML = "";

    clientes.forEach(c => {
        const fila = `
            <tr>
                <td>${c.id_cliente}</td>
                <td>${c.nombre}</td>
                <td>${c.edad}</td>
                <td>${c.fechaRegistro || ""}</td>
            </tr>
        `;
        tbody.innerHTML += fila;
    });
}

cargarClientes();
