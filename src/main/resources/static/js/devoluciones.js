const API_DEV = "https://farmacia-backend-y367.onrender.com/api/devoluciones";

document.addEventListener("DOMContentLoaded", () => {
    listarDevoluciones();

    document.getElementById("btnRegistrarDev").addEventListener("click", registrarDevolucion);
    document.getElementById("btnProcesarDev").addEventListener("click", procesarDevolucion);
    document.getElementById("btnVerificarDev").addEventListener("click", verificarPilaDevoluciones);
});

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
                            <button class="btn btn-danger btn-sm" onclick="eliminarDevolucion(${d.id_devolucion})">Eliminar</button>
                        </td>
                    </tr>
                `;
                tabla.innerHTML += row;
            });
        });
}

function registrarDevolucion() {
    const nombre = document.getElementById("productoDev").value;
    const motivo = document.getElementById("motivoDev").value;

    const obj = { nombre, motivo };

    fetch(`${API_DEV}/agregar`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    }).then(() => listarDevoluciones());
}

function procesarDevolucion() {
    fetch(`${API_DEV}/procesar`, { method: "POST" })
        .then(res => res.text())
        .then(msg => {
            alert(msg);
            listarDevoluciones();
        });
}

function verificarPilaDevoluciones() {
    fetch(`${API_DEV}/vacia`)
        .then(res => res.text())
        .then(msg => alert(msg));
}

function eliminarDevolucion(id) {
    if (!confirm("¿Seguro que deseas eliminar esta devolución?")) return;

    fetch(`${API_DEV}/${id}`, {
        method: "DELETE"
    }).then(() => listarDevoluciones());
}
