package aplicacao;

import ator.Ator;
import diretor.Diretor;
import filmes.Filmes;
import genero.Genero;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Vagner",28,15, Genero.MASCULINO);

        Ator ator = new Ator("Fabio",35,2,Genero.MASCULINO);

        Filmes filmes = new Filmes("Lagoa Azul", "Historia na ilha ", 150,1993,5.0,diretor);
        Filmes filmes1 = new Filmes("Super Heros","Sobre Heróis",150,2012,5.0,diretor);

        System.out.println("Descrição do Filme:");
        filmes.reproduzir();
        System.out.println("----");
        System.out.println("Descreição do Ator:");
        ator.mostrarNaTela();
        System.out.println("----");
        System.out.println("Descrição do Diretor:");
        diretor.mostrarNaTela();

    }
}
