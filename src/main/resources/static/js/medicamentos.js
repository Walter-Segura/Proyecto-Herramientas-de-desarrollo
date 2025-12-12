const API_MED = "https://farmacia-backend-y367.onrender.com/api/medicamentos";

document.addEventListener("DOMContentLoaded", () => {
    listarMedicamentos();

    document.getElementById("btnAgregarMed").addEventListener("click", agregarMedicamento);
    document.getElementById("btnAtenderMed").addEventListener("click", atenderMedicamento);
    document.getElementById("btnVerificarMed").addEventListener("click", verificarPilaMedicamentos);
});

function listarMedicamentos() {
    fetch(`${API_MED}/listar`)
        .then(res => res.json())
        .then(data => {
            const tabla = document.getElementById("tablaMedicamentos");
            tabla.innerHTML = "";

            data.forEach(m => {
                const row = `
                    <tr>
                        <td>${m.id_medicamento}</td>
                        <td>${m.nombre}</td>
                        <td>${m.tipo}</td>
                        <td>${m.stock}</td>
                        <td>${m.fecha_registro}</td>
                    </tr>
                `;
                tabla.innerHTML += row;
            });
        });
}

function agregarMedicamento() {
    const nombre = document.getElementById("nombreMed").value;
    const stock = parseInt(document.getElementById("cantidadMed").value);
    const tipo = document.getElementById("tipoMed").value;

    const obj = {
        nombre,
        tipo,
        stock,
        fecha_registro: new Date().toISOString()
    };

    fetch(`${API_MED}/agregar`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    }).then(() => listarMedicamentos());
}
