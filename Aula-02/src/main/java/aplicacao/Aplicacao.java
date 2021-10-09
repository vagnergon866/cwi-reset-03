package aplicacao;

import diretor.Diretor;
import filmes.Filmes;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Vagner",28,15);

        Filmes LagoaAzul = new Filmes("Lagoa Azul", "Historia na ilha ", 150,1993,4,"Vagner");
        Filmes MarvelHeros = new Filmes("MarvelHeros","Filme de Super Heróis ",180,2012,5,
        "Vagner");

        LagoaAzul.reproduzir();
    }
}
