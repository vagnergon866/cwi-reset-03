package domain;

import java.time.LocalDate;

public class Diretor {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public Diretor(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
    public String toString(){
        return "Diretor: \nId: " + id + "\nNome: " + nome +
                "\nData Nascimento: " + dataNascimento +
                "\nAno anicio atividade: " + anoInicioAtividade + ". ";
    }
}
