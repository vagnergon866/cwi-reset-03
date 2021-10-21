package br.com.cwi.reset.vagnergoncalves.request;

import br.com.cwi.reset.vagnergoncalves.domain.Diretor;
import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
import br.com.cwi.reset.vagnergoncalves.domain.Genero;

import java.util.List;

public class FilmeRequest {

    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Integer idEstudio;
    private Integer idDiretor;
    private List<PersonagemRequest> personagens;
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
