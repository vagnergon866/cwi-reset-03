package ator;

import genero.Genero;
import pessoa.Pessoa;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer quantidadeDeOscars;

    public Ator(String nome, Integer dataDeNascimento, Genero genero, Integer quantidadeDeOscars) {
        super(nome, dataDeNascimento, genero);
        this.quantidadeDeOscars = quantidadeDeOscars;

    }

}
