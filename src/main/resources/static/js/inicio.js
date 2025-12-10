// inicio.js
const API_BASE = "/api";

document.addEventListener("DOMContentLoaded", () => {
  // elementos
  const clientesCountEl = document.getElementById("countClientes");
  const medsCountEl = document.getElementById("countMedicamentos");
  const devsCountEl = document.getElementById("countDevoluciones");
  const statusEl = document.getElementById("inicioStatus");

  // mostrar loading
  if (clientesCountEl) clientesCountEl.textContent = "cargando...";
  if (medsCountEl) medsCountEl.textContent = "cargando...";
  if (devsCountEl) devsCountEl.textContent = "cargando...";

  Promise.all([
    fetchSafe(`${API_BASE}/clientes/listar`, "clientes"),
    fetchSafe(`${API_BASE}/medicamentos/listar`, "meds"),
    fetchSafe(`${API_BASE}/devoluciones/listar`, "devs")
  ]).then(([clientes, medicamentos, devoluciones]) => {
    // clientes: puede venir como String o JSON -> intentamos manejar ambos
    if (clientesCountEl) {
      if (Array.isArray(clientes)) clientesCountEl.textContent = clientes.length;
      else if (typeof clientes === "string") clientesCountEl.textContent = countLines(clientes);
      else clientesCountEl.textContent = "0";
    }

    if (medsCountEl) medsCountEl.textContent = Array.isArray(medicamentos) ? medicamentos.length : "0";
    if (devsCountEl) devsCountEl.textContent = Array.isArray(devoluciones) ? devoluciones.length : "0";

    if (statusEl) statusEl.textContent = "Conectado";
    if (statusEl) statusEl.classList.remove("text-danger");
    if (statusEl) statusEl.classList.add("text-success");
  }).catch(err => {
    console.error("Error en inicio:", err);
    if (statusEl) {
      statusEl.textContent = "Error conectando";
      statusEl.classList.remove("text-success");
      statusEl.classList.add("text-danger");
    }
    if (clientesCountEl) clientesCountEl.textContent = "-";
    if (medsCountEl) medsCountEl.textContent = "-";
    if (devsCountEl) devsCountEl.textContent = "-";
  });
});

/**
 * fetchSafe:
 * intenta obtener JSON, si falla lee como text y retorna un fallback
 * `type` solo para logging.
 */
async function fetchSafe(url, type) {
  const res = await fetch(url);
  // intentamos JSON primero
  try {
    const json = await res.clone().json();
    return json;
  } catch (e) {
    // si no es JSON, intentamos text
    try {
      const text = await res.text();
      // si es lista separada por líneas, devolvemos el text
      return text;
    } catch (e2) {
      console.warn(`fetchSafe: no se pudo parsear ${type}`, e2);
      return null;
    }
  }
}

function countLines(s) {
  if (!s) return 0;
  // elimina espacios vacíos y cuenta líneas no vacías
  return s.split("\n").filter(l => l.trim().length > 0).length;
}
