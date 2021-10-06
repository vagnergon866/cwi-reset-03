public class ItensPorQuantidade {

    static int fatiasDaTorta = 16;
    static int pao = 3600;
    static int torta = 4 * fatiasDaTorta;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static void tirarDoEstoque(String item, int qtd) {

        if ("pao".equals(item)) {
            pao = (qtd < pao) ? pao - qtd : 0;
        }
        if ("torta".equals(item)) {
            torta = (qtd < torta) ? torta - qtd : 0;
        }
        if ("sanduiche".equals(item)) {
            sanduiche = (qtd < sanduiche) ? sanduiche - qtd : 0;
        }
        if ("leite".equals(item)) {
            leite = (qtd < torta) ? leite - qtd : 0;
        }
        if ("cafe".equals(item)) {
            cafe = (qtd < cafe) ? cafe - qtd : 0;
        }
    }

    public static int adicionaItemNoEstoque(String item) {
        int quantidadeDisponivel = 0;

        if ("pao".equals(item)) {
            quantidadeDisponivel = pao;
        }
        if ("torta".equals(item)) {
            quantidadeDisponivel = torta;
        }
        if ("sanduiche".equals(item)) {
            quantidadeDisponivel = sanduiche;
        }
        if ("leite".equals(item)) {
            quantidadeDisponivel = leite;
        }
        if ("cafe".equals(item)) {
            quantidadeDisponivel = cafe;
        }
        return quantidadeDisponivel;
    }

}
