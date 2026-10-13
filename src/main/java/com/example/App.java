package com.example;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        TUI tui = new TUI();
        Calculadora calculadora = new Calculadora();
        boolean ejecutando = true;

        while (ejecutando) {
            tui.mostrarMensaje("1. sumar dos enteros");
            tui.mostrarMensaje("2. sumar dos strings");
            tui.mostrarMensaje("3. finalizar");

            int opcion = tui.pedirEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    int num1 = tui.pedirEntero("Ingrese el primer entero: ");
                    int num2 = tui.pedirEntero("Ingrese el segundo entero: ");
                    int suma = calculadora.sumarEnteros(num1, num2);
                    tui.mostrarMensaje(String.valueOf(suma));
                    break;

                case 2:
                    String texto1 = tui.pedirTexto("Ingrese el primer texto: ");
                    String texto2 = tui.pedirTexto("Ingrese el segundo texto: ");
                    String resultadoTexto = calculadora.sumarStrings(texto1, texto2);
                    tui.mostrarMensaje(resultadoTexto);
                    break;

                case 3:
                    tui.mostrarMensaje("Saliendo de la aplicación...");
                    ejecutando = false;
                    break;

                default:
                    tui.mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}
