
package Clases;


// Declaro la clase PilaMedicamentos, donde voy a manejar los medicamentos 
//usando la estructura de una pila (LIFO)
public class PilaMedicamentos {

    // Atributo privado que representa la cima de la pila, es decir, el último medicamento agregado
    private NodoMedicamento cima;

    // Constructor de la clase
    public PilaMedicamentos() {
        // Al inicio, la pila está vacía, así que la cima apunta a null
        cima = null;
    }

    // Método para apilar (agregar) un medicamento en la pila
    public void apilar(Medicamento medicamento) {
        // Creo un nuevo nodo con el medicamento que quiero agregar
        NodoMedicamento nuevo = new NodoMedicamento(medicamento);

        // Hago que el nuevo nodo apunte a la antigua cima
        nuevo.siguiente = cima;

        // Ahora actualizo la cima para que sea el nuevo nodo
        cima = nuevo;
    }

    // Método para desapilar (retirar) el medicamento que está en la cima
    public Medicamento desapilar() {
        // Si la pila está vacía, retorno null porque no hay nada que sacar
        if (cima == null) return null;

        // Guardo el medicamento que está en la cima antes de retirarlo
        Medicamento m = cima.medicamento;

        // Muevo la cima al siguiente nodo (el que estaba justo debajo)
        cima = cima.siguiente;

        // Retorno el medicamento que estaba en la cima
        return m;
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        // Devuelvo true si la cima es null, lo que significa que no hay elementos
        return cima == null;
    }

    // Método para mostrar los medicamentos apilados
    public String mostrarPila() {
        // Si la pila está vacía, devuelvo un mensaje indicándolo
        if (estaVacia()) return "La pila está vacía.";

        // Uso un StringBuilder para construir el listado de medicamentos
        StringBuilder sb = new StringBuilder();

        // Comienzo a recorrer la pila desde la cima
        NodoMedicamento actual = cima;

        // Variable para numerar los medicamentos mostrados
        int i = 1;

        // Recorro la pila hasta llegar al final (null)
        while (actual != null) {
            // Agrego la información del medicamento actual al StringBuilder
            sb.append(i + ". " + actual.medicamento.toString() + "\n");

            // Paso al siguiente nodo
            actual = actual.siguiente;

            // Aumento el contador
            i++;
        }

        // Devuelvo el contenido del StringBuilder como cadena
        return sb.toString();
    }
    
}
