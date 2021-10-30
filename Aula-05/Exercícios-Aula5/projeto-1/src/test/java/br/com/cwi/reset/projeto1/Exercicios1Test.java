package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1Test {
    Exercicios1 exercicio = new Exercicios1();

    @Test
    public void testSomaCincoNumerosInteiros(){
        // Arrange
        List<Integer> numeros = Arrays.asList(10, 1564, 200, 120, 15);
        Integer expectad = 1909;
        // Action
        Integer somarLista = exercicio.somarLista(numeros);
        // Assert
        Assertions.assertEquals(expectad, somarLista);
    }

    @Test
    public void validarSomaInteirosEUmNegativo(){
        List<Integer> numeros = Arrays.asList(10, 1564, 200, 120, -15);
        Integer expectad = 1879;

        Integer somarLista = exercicio.somarLista(numeros);

        Assertions.assertEquals(expectad, somarLista);
    }
    @Test
    public void somaComListaVazia(){
        List<Integer> numeros = Arrays.asList();
        Integer expectad = 0;

        Integer somarLista = exercicio.somarLista(numeros);

        Assertions.assertEquals(expectad, somarLista);
    }

    @Test
    public void validaSomaTresNumerosNegativos(){
        List<Integer> numeros = Arrays.asList(-10, -1564, -200);
        Integer expectad = -1774 ;

        Integer somarLista = exercicio.somarLista(numeros);

        Assertions.assertEquals(expectad, somarLista);
    }
    @Test
    public void validaSomaTodosComZero(){
        List<Integer> numeros = Arrays.asList(0,0,0,0,0);
        Integer expectad = 0;

        Integer somarLista = exercicio.somarLista(numeros);

        Assertions.assertEquals(expectad, somarLista);
    }

    @Test
    public void testCalcularMediaNumerosComCincoInteirosPositivos() {
        List<Integer> lista = Arrays.asList(5, 7, 17, 12, 21);
        Double expected = 12.4;

        Double result = exercicio.calcularMedia(lista);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaComTresInteirosNegativos() {

        List<Integer> lista = Arrays.asList(-10, -20, -30);
        Double expected = -20.0;

        Double result = exercicio.calcularMedia(lista);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaApenasComZeros() {
        List<Integer> lista = Arrays.asList(0, 0, 0, 0, 0);
        Double expected = 0.0;

        Double result = exercicio.calcularMedia(lista);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaComListaVazia() {
        List<Integer> lista = new ArrayList<>();

        Throwable exception = Assertions.assertThrows(ArithmeticException.class, () -> exercicio.calcularMedia(lista));
        Assertions.assertEquals("Erro Matematico", exception.getMessage());
    }

    @Test
    public void testInverterPalavraAbacate() {
        String palavra = "Abacate";
        String expected = "etacabA";

        String result = exercicio.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInverterPalavraBanana() {
        String palavra = "Banana";
        String expected = "ananaB";

        String result = exercicio.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInverterPalavraPessego() {
        String palavra = "Pessego";
        String expected = "ogesseP";

        String result = exercicio.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInverterPalavraMorango() {
        String palavra = "Morango";
        String expected = "ognaroM";

        String result = exercicio.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, result);
    }
}

