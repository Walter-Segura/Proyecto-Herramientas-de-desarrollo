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
    const texto = await res.text(); // backend devuelve String

    document.getElementById("listaClientes").textContent = texto;

    const tbody = document.querySelector("#tablaClientes tbody");
    tbody.innerHTML = "";

    // Cada cliente viene en una línea: ID - Nombre - Edad - Fecha
    const lineas = texto.trim().split("\n");

    lineas.forEach(linea => {
        const partes = linea.split(" - ");
        if (partes.length < 4) return;

        const fila = `
            <tr>
                <td>${partes[0]}</td>
                <td>${partes[1]}</td>
                <td>${partes[2]}</td>
                <td>${partes[3]}</td>
            </tr>
        `;
        tbody.innerHTML += fila;
    });
}


// cargar de inicio
cargarClientes();
