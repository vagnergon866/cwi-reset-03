package request;

import java.time.LocalDate;

public class DiretorRequest {

    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
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

    public String toString() {
        return "Diretor: \nNome: " + nome +
                "\nData Nascimento: " + dataNascimento +
                "\nAno anicio atividade: " + anoInicioAtividade + ". ";
    }
}
