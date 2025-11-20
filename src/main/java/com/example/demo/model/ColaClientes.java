package com.example.demo.model;

public class ColaClientes {

    private NodoCliente inicio; // Apunta al primer cliente en la cola
    private NodoCliente fin; // Apunta al último cliente en la cola

    // Inicializo la cola vacía
    public ColaClientes() {
        inicio = null;
        fin = null;
    }



    public void encolar(Cliente cliente) {
        // Aquí creo un nuevo nodo con el cliente que quiero agregar a la cola
        NodoCliente nuevo = new NodoCliente(cliente);

        // Verifico si la cola está vacía
        if (estaVacia()) {
            // Si está vacía, entonces el nuevo nodo es tanto el inicio como el final de la cola
            inicio = fin = nuevo;
        } else if (cliente.getEdad() >= 60) {
            // Si el cliente tiene 60 años o más, le doy prioridad colocándolo al inicio de la cola
            nuevo.siguiente = inicio; // Apunto el nuevo nodo hacia el nodo que actualmente es el primero
            inicio = nuevo; // Ahora el nuevo nodo se convierte en el primero de la cola
        } else {
            // Si el cliente tiene menos de 60 años, lo agrego al final de la cola como en una cola normal
            fin.siguiente = nuevo; // Apunto el último nodo actual al nuevo nodo
            fin = nuevo; // Actualizo el puntero de fin al nuevo nodo
        }
    }

    // metodo desencolar
    public Cliente desencolar() {
        // Si la cola está vacía, simplemente retorno null (no hay nada que desencolar)
        if (inicio == null) return null;

        // Creo referencias para recorrer la cola
        NodoCliente actual = inicio; // Empiezo desde el primer nodo
        NodoCliente anterior = null; // Mantengo referencia al nodo anterior mientras recorro

        NodoCliente mayorPrioridad = null; // Aquí guardaré el nodo con mayor prioridad (mayor de 60)
        NodoCliente anteriorMayor = null;  // También necesito el nodo anterior al de mayor prioridad

        // Recorro toda la cola buscando al cliente mayor de 60 con mayor edad
        while (actual != null) {
            // Si encuentro un cliente de 60 años o más
            if (actual.cliente.getEdad() >= 60) {
                // Si aún no he encontrado uno o si este tiene más edad que el anterior registrado
                if (mayorPrioridad == null || actual.cliente.getEdad() > mayorPrioridad.cliente.getEdad()) {
                    // Actualizo la referencia al cliente con mayor edad
                    mayorPrioridad = actual;
                    anteriorMayor = anterior;
                }
            }
            // Avanzo en la cola
            anterior = actual;
            actual = actual.siguiente;
        }

        // Si encontré un cliente con prioridad (mayor o igual a 60 años)
        if (mayorPrioridad != null) {
            // Guardo la información del cliente antes de eliminarlo
            Cliente c = mayorPrioridad.cliente;

            // Si el cliente con mayor prioridad es el primero de la cola
            if (mayorPrioridad == inicio) {
                // Simplemente muevo el inicio al siguiente nodo
                inicio = inicio.siguiente;
            } else {
                // Si no es el primero, hago que el nodo anterior lo salte (lo elimino de la cola)
                anteriorMayor.siguiente = mayorPrioridad.siguiente;

                // Verifico si el nodo que voy a eliminar es el último
                if (mayorPrioridad == fin) {
                    // Si lo es, actualizo el puntero del final
                    fin = anteriorMayor;
                }
            }
            // Retorno el cliente atendido con prioridad
            return c;
        }

        // Si no encontré mayores de 60, entonces atiendo al primero de la cola (FIFO normal)
        Cliente c = inicio.cliente; // Guardo el cliente a atender
        inicio = inicio.siguiente;  // Muevo el inicio al siguiente nodo

        // Si después de desencolar la cola queda vacía, actualizo el final también
        if (inicio == null) fin = null;

        // Retorno el cliente atendido
        return c;
    }

    public boolean estaVacia() {
        // Devuelvo true si el inicio es null, lo que significa que la cola está vacía
        return inicio == null;
    }

    public String mostrarCola() {
        // Si la cola está vacía, informo que no hay elementos
        if (estaVacia()) return "La cola está vacía.";

        // Creo un StringBuilder para ir armando el texto con los clientes en cola
        StringBuilder sb = new StringBuilder();
        NodoCliente actual = inicio; // Comienzo desde el primer nodo
        int i = 1; // Variable para numerar a los clientes

        // Recorro todos los nodos de la cola
        while (actual != null) {
            // Agrego la información del cliente actual al StringBuilder, con su posición
            sb.append(i + ". " + actual.cliente.toString() + "\n");
            actual = actual.siguiente; // Avanzo al siguiente nodo
            i++; // Incremento el contador
        }

        // Retorno toda la cadena construida
        return sb.toString();
    }

}
