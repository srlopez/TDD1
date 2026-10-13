package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TUITest {
private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        // Redirigir System.out para capturar lo que TUI imprime
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        // Restaurar System.in y System.out originales después de cada prueba
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void proporcionarEntrada(String datos) {
        // Simular que el usuario escribe "datos" en la terminal
        ByteArrayInputStream input = new ByteArrayInputStream(datos.getBytes());
        System.setIn(input);
    }

    @Test
    void testMostrarMensaje() {
        TUI tui = new TUI();

        tui.mostrarResultado("10");

        assertTrue(outputStreamCaptor.toString().contains("--> Resultado: 10"));
    }

@Test
    void testPedirEnteroValido() {
        proporcionarEntrada("42\n");
        TUI tui = new TUI();

        int resultado = tui.pedirEntero("Ingrese un número: ");

        assertEquals(42, resultado);
        assertTrue(outputStreamCaptor.toString().contains("Ingrese un número: "));
    }

    @Test
    void testPedirEnteroConEntradaInvalidaInicial() {
        // Simular que el usuario primero pone texto "abc" y luego el entero "15"
        proporcionarEntrada("abc\n15\n");
        TUI tui = new TUI();

        int resultado = tui.pedirEntero("Ingrese un número: ");

        assertEquals(15, resultado);
        assertTrue(outputStreamCaptor.toString().contains("Entrada inválida. Ingrese un número entero: "));
    }

    @Test
    void testPedirTexto() {
        proporcionarEntrada("Hola Mundo\n");
        TUI tui = new TUI();

        String resultado = tui.pedirTexto("Ingrese texto: ");

        assertEquals("Hola Mundo", resultado);
    }
}
