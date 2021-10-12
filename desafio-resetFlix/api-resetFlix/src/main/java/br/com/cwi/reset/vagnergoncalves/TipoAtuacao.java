package br.com.cwi.reset.vagnergoncalves;

public enum TipoAtuacao {

    PRINCIPAL("Principal"),
    COADJUVANTE("Cosdjuvante");

    private String descricao;

    TipoAtuacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
