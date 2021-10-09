package ator;

import genero.Genero;
import pessoa.Pessoa;

public class Ator extends Pessoa {

    private Integer quantidadeDeOscars;

    public Ator(String nome, Integer idade, Genero genero, Integer quantidadeDeOscars) {
        super(nome, idade, genero);
        this.quantidadeDeOscars = quantidadeDeOscars;

    }

}
