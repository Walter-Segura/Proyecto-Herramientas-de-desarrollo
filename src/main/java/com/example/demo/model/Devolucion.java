package com.example.demo.model;

public class Devolucion {
    // Declaro los atributos privados de la clase Devolucion
    private String codigoMedicamento; // Aquí voy a guardar el código del medicamento devuelto
    private String motivo;            // Aquí voy a guardar el motivo por el cual se realiza la devolución

    // Creo el constructor de la clase
    public Devolucion(String codigoMedicamento, String motivo) {
        // Al crear una instancia, asigno el valor recibido al atributo correspondiente
        this.codigoMedicamento = codigoMedicamento; // Asigno el código del medicamento que me llega por parámetro
        this.motivo = motivo;                       // Asigno el motivo que me llega por parámetro
    }

    // Creo el método getter para obtener el código del medicamento
    public String getCodigoMedicamento() {
        return codigoMedicamento; // Devuelvo el valor almacenado en codigoMedicamento
    }

    // Creo el método getter para obtener el motivo de la devolución
    public String getMotivo() {
        return motivo; // Devuelvo el motivo de la devolución
    }

    // Sobrescribo el método toString para mostrar los datos de una devolución de manera clara
    public String toString() {
        // Devuelvo una cadena con el formato que quiero para visualizar los datos
        return "Código: " + codigoMedicamento + " | Motivo: " + motivo;
    }

}