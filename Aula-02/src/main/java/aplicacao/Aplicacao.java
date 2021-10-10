package aplicacao;

import ator.Ator;
import diretor.Diretor;
import exception.AvaliacaoForaDoPadraoException;
import filmes.Filmes;
import genero.Genero;

public class Aplicacao {
    public static void main(String[] args) throws AvaliacaoForaDoPadraoException {

        Diretor diretor = new Diretor("Vagner",28,Genero.MASCULINO,12);
        Ator ator = new Ator("Fabio",35,Genero.MASCULINO,5);

        Filmes LagoaAzul = new Filmes("Lagoa Azul", "História na ilha ", 150,1992,4.0,diretor);
        Filmes SuperHeros = new Filmes("Super Heros","História dos Heróis",160,2012,.0,diretor);


        System.out.println("Descrição do Filme:");
        LagoaAzul.reproduzir();
        System.out.println("----");
        SuperHeros.reproduzir();
        System.out.println("----");

        System.out.println("Descreição do Ator:");
        ator.mostrarNaTela();
        System.out.println("----");
        System.out.println("Descrição do Diretor:");
        diretor.mostrarNaTela();

    }

}
