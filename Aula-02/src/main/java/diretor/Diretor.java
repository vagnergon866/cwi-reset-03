package diretor;


import genero.Genero;
import pessoa.Pessoa;

public class Diretor extends Pessoa {

    private  Integer quantidadeDeFilmes;

    public Diretor(String nome, Integer idade, Genero genero, Integer quantidadeDeFilmes){
        super(nome, idade, genero);
        this.quantidadeDeFilmes = quantidadeDeFilmes;



    }

}
