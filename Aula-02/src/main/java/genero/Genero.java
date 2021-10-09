package genero;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIO("Não Binario");

    private String descricoes;

    Genero(String descricoes){
        this.descricoes = descricoes;
    }

    public String getDescricoes() {
        return descricoes;
    }
}
