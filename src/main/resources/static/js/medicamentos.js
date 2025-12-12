const API_BASE = "https://farmacia-backend-y367.onrender.com/api/medicamentos";

document.addEventListener("DOMContentLoaded", () => {
    listarMedicamentos();
    document.getElementById("btnAgregarMed").addEventListener("click", agregarMedicamento);
});

function listarMedicamentos() {
    fetch(`${API_BASE}/listar`)
        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById("tabla-body");
            tbody.innerHTML = "";

            data.forEach(m => {
                tbody.innerHTML += `
                    <tr>
                        <td>${m.id_medicamento}</td>
                        <td>${m.nombre}</td>
                        <td>${m.stock}</td>
                        <td>${m.fecha_registro || ""}</td>
                        <td>
                            <button class="btn btn-danger btn-sm" onclick="eliminarMedicamento(${m.id_medicamento})">
                                Eliminar
                            </button>
                        </td>
                    </tr>
                `;
            });
        });
}

function agregarMedicamento() {
    const nombre = document.getElementById("nombreMed").value.trim();
    const stock = document.getElementById("cantidadMed").value;

    if (!nombre || !stock) {
        alert("Nombre y cantidad son obligatorios.");
        return;
    }

    const obj = {
        nombre: nombre,
        stock: stock,
        tipo: "General"
    };

    fetch(`${API_BASE}/agregar`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    })
    .then(() => {
        listarMedicamentos();
        document.getElementById("nombreMed").value = "";
        document.getElementById("cantidadMed").value = "";
    });
}

function eliminarMedicamento(id) {
    if (!confirm("¿Seguro que deseas eliminar este medicamento?")) return;

    fetch(`${API_BASE}/${id}`, { method: "DELETE" })
        .then(() => listarMedicamentos());
}
