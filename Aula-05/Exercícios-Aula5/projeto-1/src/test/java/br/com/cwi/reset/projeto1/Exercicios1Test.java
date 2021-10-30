package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercicios1Test {
    Exercicios1 exercicio = new Exercicios1();

    @Test
    public void testSomaCincoNumerosInteiros(){

        List<Integer> numeros = Arrays.asList(10, 1564, 200, 120, 15);
        Integer expectad = 1909;

        Integer somarLista = exercicio.somarLista(numeros);

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

}

