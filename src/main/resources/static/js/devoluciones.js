const API_BASE = "https://farmacia-backend-y367.onrender.com/api";
const API_DEV = `${API_BASE}/devoluciones`;
const API_MED = `${API_BASE}/medicamentos`;

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
                        <td>${d.medicamento?.nombre}</td>
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
        cantidad: 1,   // cambiar si quieres
        medicamento: { id_medicamento: med.id_medicamento }
    };

    fetch(API_DEV, {
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

// PROCESAR (si no existe en backend, dará 404)
function procesarDevolucion() {
    fetch(`${API_DEV}/procesar`, { method: "POST" })
        .then(res => res.text())
        .then(msg => {
            alert(msg);
            listarDevoluciones();
        });
}

// VERIFICAR VACÍO (si no existe en backend, dará 404)
function verificarPilaDevoluciones() {
    fetch(`${API_DEV}/vacia`)
        .then(res => res.text())
        .then(msg => alert(msg));
}

// BUSCAR MEDICAMENTO POR NOMBRE
async function buscarMedicamentoPorNombre(nombre) {
    const res = await fetch(API_MED);
    const lista = await res.json();

    return lista.find(m => m.nombre.toLowerCase() === nombre.toLowerCase());
}
