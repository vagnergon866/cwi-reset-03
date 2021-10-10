package ator;

import genero.Genero;
import pessoa.Pessoa;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer quantidadeDeOscars;

    public Ator(String nome, LocalDate dataNascimento, Genero genero, Integer quantidadeDeOscars) {
        super(nome, dataNascimento, genero);
        this.quantidadeDeOscars = quantidadeDeOscars;

    }

}
