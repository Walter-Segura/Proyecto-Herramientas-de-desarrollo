
package Clases;


// Declaro la clase PilaDevoluciones, que representa una pila donde voy a guardar objetos de tipo Devolucion
public class PilaDevoluciones {

    // Atributo privado que representa la cima de la pila (el último elemento apilado)
    private NodoDevolucion cima;

    // Constructor de la clase
    public PilaDevoluciones() {
        // Al iniciar la pila, la cima está vacía (null)
        cima = null;
    }

    // Método para apilar una nueva devolución (agregar un elemento en la cima)
    public void apilar(Devolucion devolucion) {
        // Primero creo un nuevo nodo con la devolución que quiero agregar
        NodoDevolucion nuevo = new NodoDevolucion(devolucion);

        // Apunto el nuevo nodo hacia la antigua cima, porque él va a quedar encima de ella
        nuevo.siguiente = cima;

        // Ahora actualizo la cima para que apunte al nuevo nodo
        cima = nuevo;
    }


  // Método para desapilar una devolución (quitar el elemento que está en la cima)
public Devolucion desapilar() {
    // Verifico si la pila está vacía; si lo está, no hay nada que devolver, así que retorno null
    if (cima == null) return null;

    // Guardo la devolución que está en la cima antes de quitarla
    Devolucion d = cima.devolucion;

    // Muevo la cima al siguiente nodo (el que estaba debajo)
    cima = cima.siguiente;

    // Retorno la devolución que estaba en la cima
    return d;
}

// Método para verificar si la pila está vacía
public boolean estaVacia() {
    // Retorno true si la cima es null, lo que significa que no hay ningún elemento en la pila
    return cima == null;
}

// Método para mostrar todas las devoluciones apiladas
public String mostrarPila() {
    // Si la pila está vacía, retorno un mensaje indicándolo
    if (estaVacia()) return "No hay devoluciones registradas.";

    // Creo un StringBuilder para ir construyendo el texto con las devoluciones apiladas
    StringBuilder sb = new StringBuilder();

    // Comienzo desde la cima de la pila
    NodoDevolucion actual = cima;

    // creo una variable para numerar cada devolución al mostrarla
    int i = 1;

    // Recorro todos los nodos de la pila mientras no llegue al final (null)
    while (actual != null) {
        // Agrego al StringBuilder la información de la devolución actual con su número
        sb.append(i + ". " + actual.devolucion.toString() + "\n");

        // Paso al siguiente nodo en la pila
        actual = actual.siguiente;

        // Aumento el contador
        i++;
    }

    // Retorno el contenido completo del StringBuilder como texto
    return sb.toString();
    }
    
}
