package br.com.cwi.reset.vagnergoncalves.domain;

public enum Genero {

    ACAO("Ação"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    DOCUMENTARIO("Documentário"),
    DRAMA("Drama"),
    ESPIONAGEM("Espionagem"),
    FICCAO_CIENTIFICA("Ficção cientifica"),
    GUERRA("Guerra"),
    MISTERIO("Mistério"),
    MUSICAL("Musical"),
    POLICIAL("Policial"),
    ROMANCE("Romance"),
    TERROR("Terror");

    Genero(String descricao) {
        this.descricao = descricao;

    }
    private String descricao;

    public String getDescricao(){
        return descricao;
    }
}
