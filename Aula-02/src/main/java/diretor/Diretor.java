package diretor;

import aplicacao.Genero;

public class Diretor {
    private String nome;
    private Integer idade;
    private  Integer quantidadeDeFilmes;
    private Genero genero;

    public Diretor(String nome, Integer idade, Integer quantidadeDeFilmes, Genero genero){
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmes = quantidadeDeFilmes;
        this.genero = genero;
    }

    public void mostrarNaTela(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero: " + genero.getDescricoes());
    }

    public String getNome() {
        return nome;
    }

}
