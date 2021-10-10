package pessoa;

import genero.Genero;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa<dataDeNascimento> {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void mostrarNaTela() {
        System.out.println("Nome: " + nome);
        System.out.println("Data do nascimento: " + this.dataNascimento);
        System.out.println("Genero: " + genero.getDescricoes());
    }

    public String getNome() {
        return nome;
    }

    public void  calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        System.out.println("Idade: " + periodo.getYears());

    }


}



