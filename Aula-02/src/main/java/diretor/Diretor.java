package diretor;


import genero.Genero;
import pessoa.Pessoa;

import java.time.LocalDate;

public class Diretor extends Pessoa {
    private  Integer quantidadeDeFilmes;

    public Diretor(String nome, Integer dataDeNascimento, Genero genero, Integer quantidadeDeFilmes){
        super(nome, dataDeNascimento, genero);
        this.quantidadeDeFilmes = quantidadeDeFilmes;

    }

}
