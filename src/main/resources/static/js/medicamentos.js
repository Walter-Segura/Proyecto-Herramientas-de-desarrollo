const API_MED = "https://farmacia-backend-y367.onrender.com/api/medicamentos";

document.addEventListener("DOMContentLoaded", () => {
    listarMedicamentos();

    document.getElementById("btnAgregarMed").addEventListener("click", agregarMedicamento);

    // Desactivamos botones que no existen en backend
    document.getElementById("btnAtenderMed").addEventListener("click", () => {
        alert("Esta función no está implementada en el backend.");
    });

    document.getElementById("btnVerificarMed").addEventListener("click", () => {
        alert("Esta función no está implementada en el backend.");
    });
});

function listarMedicamentos() {
    fetch(`${API_MED}/listar`)
        .then(res => res.json())
        .then(data => {
            const tabla = document.querySelector("#tablaMedicamentos tbody");
            tabla.innerHTML = "";

            data.forEach(m => {
                const row = `
                    <tr>
                        <td>${m.id_medicamento}</td>
                        <td>${m.nombre}</td>
                        <td>${m.stock}</td>
                        <td>${m.fecha_registro || ""}</td>
                    </tr>
                `;
                tabla.innerHTML += row;
            });
        });
}

function agregarMedicamento() {
    const nombre = document.getElementById("nombreMed").value.trim();
    const cantidad = document.getElementById("cantidadMed").value;

    if (!nombre || !cantidad) {
        alert("Nombre y cantidad son obligatorios.");
        return;
    }

    const obj = {
        nombre: nombre,
        stock: cantidad,
        tipo: "General" // valor fijo para evitar null
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
