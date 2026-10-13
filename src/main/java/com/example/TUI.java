package com.example;

import java.util.Scanner;

public class TUI implements AutoCloseable{
    private final Scanner scanner;

    public TUI() {
        this.scanner = new Scanner(System.in);
    }

    public int pedirEntero(String mensaje) {
        if (!mensaje.isEmpty()) {
            System.out.print(mensaje);
        }
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un número entero: ");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea del buffer
        return numero;
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Este método se ejecutará AUTOMÁTICAMENTE al salir del bloque try
    @Override
    public void close() {
        scanner.close();
        System.out.println("Liberando recursos de forma segura...");
    }
}