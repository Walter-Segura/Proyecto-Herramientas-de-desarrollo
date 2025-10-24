
package Clases;


public class Medicamento {
     // Declaro los atributos privados de la clase Medicamento
private String nombre;              // Aquí guardo el nombre del medicamento
private String codigo;              // Aquí almaceno el código único que identifica al medicamento
private String fechaVencimiento;    // En este campo guardo la fecha de vencimiento del medicamento

// Defino el constructor de la clase Medicamento
public Medicamento(String nombre, String codigo, String fechaVencimiento) {
    // Asigno a cada atributo el valor que recibo por parámetro al crear el objeto
    this.nombre = nombre;                         // Guardo el nombre del medicamento
    this.codigo = codigo;                         // Guardo el código del medicamento
    this.fechaVencimiento = fechaVencimiento;     // Guardo la fecha de vencimiento
}

// Creo el método getter para obtener el nombre del medicamento
public String getNombre() {
    return nombre; // Devuelvo el nombre almacenado en el atributo
}

// Creo el método getter para obtener el código del medicamento
public String getCodigo() {
    return codigo; // Devuelvo el código del medicamento
}

// Creo el método getter para obtener la fecha de vencimiento
public String getFechaVencimiento() {
    return fechaVencimiento; // Devuelvo la fecha en que vence el medicamento
}

// Sobrescribo el método toString para mostrar la información del medicamento de forma clara
@Override
public String toString() {
    // Devuelvo una cadena de texto con los datos del medicamento formateados para que se entiendan fácilmente
    return nombre + " | Código: " + codigo + " | Vence: " + fechaVencimiento;
}
    
}
