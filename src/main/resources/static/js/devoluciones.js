const API_DEV = "https://farmacia-backend-y367.onrender.com/api/devoluciones";

document.addEventListener("DOMContentLoaded", () => {
    listarDevoluciones();

    document.getElementById("btnRegistrarDev").addEventListener("click", registrarDevolucion);
    document.getElementById("btnProcesarDev").addEventListener("click", procesarDevolucion);
    document.getElementById("btnVerificarDev").addEventListener("click", verificarPilaDevoluciones);
});

function listarDevoluciones() {
    fetch(`${API_DEV}/listar`)
        .then(res => res.json())
        .then(data => {
            const tabla = document.getElementById("tablaDevoluciones");
            tabla.innerHTML = "";

            data.forEach(d => {
                const row = `
                    <tr>
                        <td>${d.id}</td>
                        <td>${d.producto}</td>
                        <td>${d.motivo}</td>
                    </tr>
                `;
                tabla.innerHTML += row;
            });
        });
}

function registrarDevolucion() {
    const producto = document.getElementById("productoDev").value;
    const motivo = document.getElementById("motivoDev").value;

    const obj = { producto, motivo };

    fetch(`${API_DEV}/registrar`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    }).then(() => listarDevoluciones());
}

function procesarDevolucion() {
    fetch(`${API_DEV}/procesar`, { method: "DELETE" })
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
