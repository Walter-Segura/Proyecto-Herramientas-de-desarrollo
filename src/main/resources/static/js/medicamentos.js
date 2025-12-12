const API_BASE = "https://farmacia-backend-y367.onrender.com/api/medicamentos";

document.addEventListener("DOMContentLoaded", () => {
    listarMedicamentos();
    document.getElementById("btnAgregarMed").addEventListener("click", agregarMedicamento);

    document.getElementById("btnAtenderMed").addEventListener("click", () => {
        alert("Función no implementada");
    });
    document.getElementById("btnVerificarMed").addEventListener("click", () => {
        alert("Función no implementada");
    });
});

function listarMedicamentos() {
    fetch(`${API_BASE}/listar`)
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector("#tablaMedicamentos tbody");
            tbody.innerHTML = "";

            data.forEach(m => {
                tbody.innerHTML += `
                    <tr>
                        <td>${m.id_medicamento}</td>
                        <td>${m.nombre}</td>
                        <td>${m.stock}</td>
                        <td>${m.fecha_registro ?? ""}</td>
                    </tr>
                `;
            });
        });
}

function agregarMedicamento() {
    const nombre = document.getElementById("nombreMed").value;
    const cantidad = document.getElementById("cantidadMed").value;

    const obj = {
        nombre: nombre,
        stock: cantidad,
        tipo: "General"
    };

    fetch(`${API_BASE}/agregar`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    })
    .then(() => listarMedicamentos());
}
