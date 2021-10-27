package br.com.cwi.reset.vagnergoncalves.request;

import br.com.cwi.reset.vagnergoncalves.domain.Genero;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmeRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome.")
    private String nome;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo anoLancamento.")
    private Integer anoLancamento;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo capaFilme.")
    private String capaFilme;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo generos.")
    @NotEmpty(message = "Deve ser informado pelo menos um gênero para o cadastro do filme.")
    private List<Genero> generos;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo ideEstudio.")
    private Integer idEstudio;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo idDiretor.")
    private Integer idDiretor;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo personagens.")
    @Valid
    private List<PersonagemRequest> personagens;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo resumo.")
    private String resumo;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme,
                        List<Genero> generos, Integer idEstudio, Integer idDiretor, List<PersonagemRequest> personagens, String resumo) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.idEstudio = idEstudio;
        this.idDiretor = idDiretor;
        this.personagens = personagens;
        this.resumo = resumo;
    }
    public FilmeRequest(){

    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public Integer getIdDiretor() {
        return idDiretor;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }

    public String getResumo() {
        return resumo;
    }
}
