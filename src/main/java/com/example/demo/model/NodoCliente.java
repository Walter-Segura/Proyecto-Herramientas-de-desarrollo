package com.example.demo.model;

public class NodoCliente {

    // Atributo para guardar el objeto Cliente dentro del nodo
    Cliente cliente;

    // Atributo que apunta al siguiente nodo en la cola (enlace)
    NodoCliente siguiente;

    // Constructor del nodo
    public NodoCliente(Cliente cliente) {
        // Cuando creo un nodo, le asigno el cliente que recibo por parámetro
        this.cliente = cliente;

        // Inicialmente, el siguiente nodo es null porque todavía no lo enlazo a nadie
        this.siguiente = null;

    }

}