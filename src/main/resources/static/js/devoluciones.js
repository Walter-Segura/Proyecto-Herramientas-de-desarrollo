const API_DEV = "https://farmacia-backend-y367.onrender.com/api/devoluciones/listar";

document.addEventListener("DOMContentLoaded", () => {
    listarDevoluciones();

    document.getElementById("btnRegistrarDev").addEventListener("click", registrarDevolucion);
    document.getElementById("btnProcesarDev").addEventListener("click", procesarDevolucion);
    document.getElementById("btnVerificarDev").addEventListener("click", verificarPilaDevoluciones);
});

// LISTAR
function listarDevoluciones() {
    fetch(API_DEV)
        .then(res => res.json())
        .then(data => {
            const tabla = document.getElementById("tablaDevoluciones");
            tabla.innerHTML = "";

            data.forEach(d => {
                const row = `
                    <tr>
                        <td>${d.id_devolucion}</td>
                        <td>${d.medicamento?.nombre ?? d.nombre}</td>
                        <td>${d.cantidad}</td>
                        <td>${d.fecha}</td>
                        <td>
                            <button class="btn btn-danger btn-sm" onclick="eliminarDevolucion(${d.id_devolucion})">
                                Eliminar
                            </button>
                        </td>
                    </tr>
                `;
                tabla.innerHTML += row;
            });
        });
}

// REGISTRAR
async function registrarDevolucion() {
    const nombre = document.getElementById("productoDev").value.trim();
    const motivo = document.getElementById("motivoDev").value.trim();

    if (!nombre || !motivo) {
        alert("Completa los campos.");
        return;
    }

    // Buscar medicamento por nombre
    const med = await buscarMedicamentoPorNombre(nombre);

    if (!med) {
        alert("El medicamento no existe.");
        return;
    }

    const obj = {
        cantidad: 1,   // puedes cambiarlo
        medicamento: { id_medicamento: med.id_medicamento }
    };

    fetch("https://farmacia-backend-y367.onrender.com/api/devoluciones", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    }).then(() => listarDevoluciones());
}


// ELIMINAR
function eliminarDevolucion(id) {
    if (!confirm("¿Eliminar esta devolución?")) return;

    fetch(`${API_DEV}/${id}`, {
        method: "DELETE"
    }).then(() => listarDevoluciones());
}

// PROCESAR (requiere backend)
function procesarDevolucion() {
    fetch(`${API_DEV}/procesar`, { method: "POST" })
        .then(res => res.text())
        .then(msg => {
            alert(msg);
            listarDevoluciones();
        });
}

// VERIFICAR VACÍO (requiere backend)
function verificarPilaDevoluciones() {
    fetch(`${API_DEV}/vacia`)
        .then(res => res.text())
        .then(msg => alert(msg));
}

async function buscarMedicamentoPorNombre(nombre) {
    const res = await fetch("https://farmacia-backend-y367.onrender.com/api/medicamentos/listar");
    const lista = await res.json();

    return lista.find(m => m.nombre.toLowerCase() === nombre.toLowerCase());
}


