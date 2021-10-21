package br.com.cwi.reset.vagnergoncalves.exception;

import br.com.cwi.reset.vagnergoncalves.domain.Estudio;

public enum TipoDominioException {
    ATOR("ator", "atores"),
    DIRETOR("diretor", "diretores"),
    Estudio("estudio", "estudios"),
    Filme("filme","filmes");

    private final String singular;
    private final String plural;

    TipoDominioException(final String singular, final String plural){
        this.singular = singular;
        this.plural = plural;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }
}
