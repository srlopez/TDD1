package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    @Test
    void testSumarEnteros() {
        assertEquals(5, new Calculadora().sumar(2, 3));
    }

    @Test
    void testSumarStrings() {
        assertEquals("Hola Mundo", new Calculadora().sumar("Hola ", "Mundo"));

    }
}
