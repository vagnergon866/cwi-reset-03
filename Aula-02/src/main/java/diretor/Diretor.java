package diretor;


import genero.Genero;
import pessoa.Pessoa;

import java.time.LocalDate;

public class Diretor extends Pessoa {
    private  Integer quantidadeDeFilmes;

    public Diretor(String nome, LocalDate dataNascimento, Genero genero, Integer quantidadeDeFilmes){
        super(nome, dataNascimento, genero);
        this.quantidadeDeFilmes = quantidadeDeFilmes;


    }

}
