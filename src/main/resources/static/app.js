const API = "https://farmacia-backend-y367.onrender.com";

// ---------------- Medicamentos ----------------

function agregarMedicamento() {
    let nombre = document.getElementById("nombreMed").value;
    let cantidad = document.getElementById("cantidadMed").value;

    fetch(API + "/medicamentos/agregar", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            nombre: nombre,
            cantidad: cantidad
        })
    }).then(() => alert("Medicamento agregado!"));
}

function desapilarMedicamento() {
    fetch(API + "/medicamentos/desapilar")
        .then(res => res.text())
        .then(data => alert("Retirado: " + data));
}

function mostrarPilaMedicamentos() {
    fetch(API + "/medicamentos/mostrar")
        .then(res => res.text())
        .then(data => document.getElementById("resultadoPilaMedicamentos").textContent = data);
}

// ---------------- Devoluciones ----------------

function agregarDevolucion() {
    let nombre = document.getElementById("nombreDev").value;
    let motivo = document.getElementById("motivoDev").value;

    fetch(API + "/devoluciones/agregar", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            nombre: nombre,
            motivo: motivo
        })
    }).then(() => alert("Devolución registrada!"));
}

function mostrarPilaDevoluciones() {
    fetch(API + "/devoluciones/mostrar")
        .then(res => res.text())
        .then(data => document.getElementById("resultadoPilaDevoluciones").textContent = data);
}
