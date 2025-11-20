package com.example.demo.model;

public class Cliente {
    // Declaro los atributos que va a tener cada cliente
    private String nombre;
    private String dni;
    private String producto;
    private int edad;

    // Creo un constructor para que al registrar un cliente, pueda darle los siguientes datos
    public Cliente(String nombre, String dni, String producto, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.producto = producto;
        this.edad = edad;
    }

    //Métodos get para obtener cada dato del cliente
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getProducto() { return producto; }
    public int getEdad() { return edad; }

    // Este método me servirá para mostrar la información del cliente en forma de texto
    public String toString() {
        return nombre + " - DNI: " + dni + " - Edad: " + edad + " - Producto: " + producto;
    }

}