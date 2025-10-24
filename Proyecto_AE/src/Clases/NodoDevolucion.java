
package Clases;

// Declaro la clase NodoDevolucion, que voy a usar para construir una estructura
//tipo lista o pila para las devoluciones
public class NodoDevolucion {
    
    // Atributo para guardar un objeto de tipo Devolucion dentro del nodo
    Devolucion devolucion;

    // Atributo que apunta al siguiente nodo en la estructura (el nodo que viene después)
    NodoDevolucion siguiente;

    // Constructor de la clase NodoDevolucion
    public NodoDevolucion(Devolucion devolucion) {
        // Al crear el nodo, asigno el objeto Devolucion recibido al atributo correspondiente
        this.devolucion = devolucion;

        // Inicialmente, no hay un nodo siguiente, por eso lo establezco como null
        this.siguiente = null;
    }
}
