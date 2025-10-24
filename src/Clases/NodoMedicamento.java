
package Clases;


// Declaro la clase NodoMedicamento, que me permite representar un nodo 
//dentro de una estructura tipo pila o lista para medicamentos
public class NodoMedicamento {
    
    // Atributo para guardar un objeto de tipo Medicamento dentro del nodo
    Medicamento medicamento;

    // Atributo que apunta al siguiente nodo en la estructura
    NodoMedicamento siguiente;

    // Constructor de la clase NodoMedicamento
    public NodoMedicamento(Medicamento medicamento) {
        // Asigno el objeto Medicamento que recibo por parámetro al atributo del nodo
        this.medicamento = medicamento;

        // Inicialmente, este nodo no apunta a ningún otro, así que lo dejo en null
        this.siguiente = null;
    }
    
}
