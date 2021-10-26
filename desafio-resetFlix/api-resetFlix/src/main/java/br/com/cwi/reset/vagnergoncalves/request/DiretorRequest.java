package br.com.cwi.reset.vagnergoncalves.request;

import br.com.cwi.reset.vagnergoncalves.domain.Diretor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

public class DiretorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo, nome")
    private String nome;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo, dataNascimento")
    @Past(message = "Não é possível cadastrar atores não nascidos.")
    private LocalDate dataNascimento;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo, anoInicioAtividade")
    private Integer anoInicioAtividade;

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }
    public DiretorRequest(List<Diretor> diretores){

    }
    public Diretor convertObjeto(){
        return  new Diretor(nome, dataNascimento, anoInicioAtividade);
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

}
