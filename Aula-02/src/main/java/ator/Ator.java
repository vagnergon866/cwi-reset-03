package ator;

import aplicacao.Genero;

public class Ator {
    private String nome;
    private Integer idade;
    private Integer quantidadeDeOscars;
    private Genero genero;



    public Ator(String nome, Integer idade, Integer quantidadeDeOscars, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeOscars = quantidadeDeOscars;
        this.genero = genero;
    }


    public void mostrarNaTela(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero: " + genero.getDescricoes());
    }

}
