package pessoa;

import genero.Genero;

public abstract class  Pessoa {
    private String nome;
    private Integer idade;
    private Genero genero;

    public Pessoa(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
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
