package domain;

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
