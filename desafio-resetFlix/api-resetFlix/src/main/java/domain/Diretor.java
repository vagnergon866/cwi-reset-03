package domain;

import java.time.LocalDate;

public class Diretor {

    private Integer id;
    private System nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public Diretor(Integer id, System nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
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

    public System getNome() {
        return nome;
    }
}
