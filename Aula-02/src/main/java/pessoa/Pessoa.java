package pessoa;

import genero.Genero;

public abstract class Pessoa<dataDeNascimento> {
    private String nome;
    private Integer dataDeNascimento;
    private Genero genero;

    public Pessoa(String nome, Integer dataDeNascimento, Genero genero) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
    }

    public void mostrarNaTela() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + dataDeNascimento);
        System.out.println("Genero: " + genero.getDescricoes());
    }

    public String getNome() {
        return nome;
    }

}
