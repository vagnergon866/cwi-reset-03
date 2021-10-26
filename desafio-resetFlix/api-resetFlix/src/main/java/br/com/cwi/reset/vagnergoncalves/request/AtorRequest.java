package br.com.cwi.reset.vagnergoncalves.request;

import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.domain.StatusCarreira;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;


public class AtorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo, nome")
    private String nome;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo, dataNascimento")
    @Past(message = "Não é possível cadastrar atores não nascidos.")
    private LocalDate dataNascimento;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo, statusCarreira")
    private StatusCarreira statusCarreira;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo, anoInicioAtividade")
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }
    public AtorRequest(List<Ator> atores){
    }
   public Ator converteObjeto(){
        return new Ator(nome, dataNascimento,statusCarreira,anoInicioAtividade);
   }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }


}
