
package Clases;

import javax.swing.JOptionPane;

public class MenuPrincipal {

    public static void main(String[] args) {
        // Creo una instancia de la clase ColaClientes para manejar la cola de atención
        // de clientes
        ColaClientes colaClientes = new ColaClientes();

        // Datos precargados

        //// Creo una instancia de la clase PilaMedicamentos para manejar los
        //// medicamentos
        // como una pila (último en entrar, primero en salir)
        PilaMedicamentos pilaMedicamentos = new PilaMedicamentos();

        // datos precargados

        // Creo una instancia de la clase PilaDevoluciones para manejar las devoluciones
        // también como una pila
        PilaDevoluciones pilaDevoluciones = new PilaDevoluciones();

        // Variable para guardar la opción que el usuario elige en el menú
        String opcion;

        // Inicio el ciclo do-while para mostrar el menú repetidamente hasta que el
        // usuario decida salir
        do {
            // Muestro el menú usando JOptionPane para que sea más visual e interactivo
            opcion = JOptionPane.showInputDialog(
                    "=== MENÚ DEL SISTEMA FARMACÉUTICO ===\n\n" +
                            "1. Añadir cliente a la cola\n" + // Opción para registrar un nuevo cliente
                            "2. Atender cliente\n" + // Opción para atender al siguiente cliente en la cola
                            "3. Ver cola actual\n\n" + // Opción para mostrar todos los clientes en la cola

                            "4. Registrar medicamento\n" + // Opción para apilar (registrar) un nuevo medicamento
                            "5. Vender medicamento\n" + // Opción para desapilar (vender) un medicamento
                            "6. Ver pila de medicamentos\n\n" + // Opción para ver todos los medicamentos apilados

                            "7. Registrar devolución\n" + // Opción para registrar una devolución en la pila
                                                          // correspondiente
                            "8. Ver devoluciones\n\n" + // Opción para mostrar todas las devoluciones registradas

                            "9. Salir\n\n" + // Opción para cerrar el programa
                            "Elige una opción:" // Mensaje que guía al usuario a escribir su selección
            );

            // Utilizo un switch para manejar las opciones del menú que el usuario elige
            switch (opcion) {
                case "1" -> registrarCliente(colaClientes);

                case "2" -> {
                    // Opción 2: Atender al siguiente cliente en la cola

                    // Llamo al método desencolar para obtener el cliente que será atendido
                    Cliente atendido = colaClientes.desencolar();

                    // Verifico si la cola estaba vacía
                    if (atendido == null) {
                        // Si no había clientes, muestro un mensaje informando que no hay nadie en la
                        // cola
                        JOptionPane.showMessageDialog(null, "No hay clientes en la cola.");
                    } else {
                        // Si hay un cliente, muestro sus datos indicando que fue atendido
                        JOptionPane.showMessageDialog(null, "Cliente atendido:\n" + atendido);
                    }
                }

                case "3" -> {
                    // Opción 3: Ver la cola actual de clientes
                    // Llamo al método mostrarCola() para obtener el listado completo de los
                    // clientes en la cola
                    // Luego muestro ese contenido en un cuadro de diálogo
                    JOptionPane.showMessageDialog(null, colaClientes.mostrarCola());
                }
                case "4" -> {
                    // Opción 4: Registrar un nuevo medicamento

                    // Solicito al usuario que ingrese el nombre del medicamento
                    String nombre = JOptionPane.showInputDialog("Nombre del medicamento:");

                    // Solicito el código único del medicamento
                    String codigo = JOptionPane.showInputDialog("Código del medicamento:");

                    // Solicito la fecha de vencimiento del medicamento
                    String vencimiento = JOptionPane.showInputDialog("Fecha de vencimiento:");

                    // Creo un objeto Medicamento con los datos proporcionados
                    Medicamento m = new Medicamento(nombre, codigo, vencimiento);

                    // Apilo el medicamento en la pila correspondiente
                    pilaMedicamentos.apilar(m);

                    // Muestro mensaje confirmando el registro
                    JOptionPane.showMessageDialog(null, "Medicamento registrado.");
                }

                case "5" -> {
                    // Opción 5: Vender medicamento (quitar el de la cima de la pila)

                    // Llamo al método desapilar para retirar el último medicamento agregado
                    Medicamento vendido = pilaMedicamentos.desapilar();

                    // Verifico si la pila estaba vacía
                    if (vendido == null) {
                        // Si no había medicamentos, muestro mensaje
                        JOptionPane.showMessageDialog(null, "No hay medicamentos en la pila.");
                    } else {
                        // Si se vendió un medicamento, muestro sus datos
                        JOptionPane.showMessageDialog(null, "Medicamento vendido:\n" + vendido);
                    }
                }

                case "6" -> {
                    // Opción 6: Mostrar todos los medicamentos registrados en la pila

                    // Llamo al método mostrarPila() para obtener el listado de medicamentos y lo
                    // muestro
                    JOptionPane.showMessageDialog(null, pilaMedicamentos.mostrarPila());
                }

                case "7" -> {
                    // Opción 7: Registrar una devolución de medicamento

                    // Solicito el código del medicamento que se va a devolver
                    String codigo = JOptionPane.showInputDialog("Código del medicamento devuelto:");

                    // Solicito el motivo por el cual se realiza la devolución
                    String motivo = JOptionPane.showInputDialog("Motivo de la devolución:");

                    // Creo un nuevo objeto Devolucion con la información ingresada
                    Devolucion d = new Devolucion(codigo, motivo);

                    // Apilo la devolución en la pila de devoluciones
                    pilaDevoluciones.apilar(d);

                    // Muestro un mensaje de confirmación
                    JOptionPane.showMessageDialog(null, "Devolución registrada.");
                }

                case "8" -> {
                    // Opción 8: Ver todas las devoluciones registradas

                    // Llamo al método mostrarPila() de devoluciones para mostrar todas las
                    // devoluciones almacenadas
                    JOptionPane.showMessageDialog(null, pilaDevoluciones.mostrarPila());
                }

                case "9" -> {
                    // Opción 9: Salir del sistema

                    // Muestro un mensaje de despedida
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. (MAIN)");
                }

                default -> {
                    // Caso por defecto: si el usuario ingresó una opción inválida (que no esté
                    // entre 1 y 9)

                    // Me aseguro de que la opción no sea null (por si cierra el cuadro de entrada)
                    if (opcion != null)
                        JOptionPane.showMessageDialog(null, "Opción no válida. (MAIN)");
                }
            }

            // El bucle se repite mientras la opción elegida no sea "9"
        } while (!"9".equals(opcion));

    }
    private static void registrarCliente(ColaClientes colaClientes) {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        String dni = JOptionPane.showInputDialog("DNI:");
        String producto = JOptionPane.showInputDialog("Producto solicitado:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));

        Cliente c = new Cliente(nombre, dni, producto, edad);
        colaClientes.encolar(c);
        JOptionPane.showMessageDialog(null, "Cliente añadido a la cola.");
    }    

}
