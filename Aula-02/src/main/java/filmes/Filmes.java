package filmes;

import diretor.Diretor;

public class Filmes {

    private String nome;
    private String descrisao;
    private Integer tempo;
    private Integer anoLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filmes(String nomeDoFilme, String descrisao, Integer tempo, Integer anoLancamento, Integer avaliacao, Diretor diretor){
        this.nome = nomeDoFilme;
        this.descrisao = descrisao;
        this.tempo = tempo;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public Filmes(String lagoa_azul, String historia_na_ilha, int tempo, int anoLancamento, int avaliacao, String vagner) {
    }

    public void reproduzir(){
        System.out.println("Lagoa Azul" + nome);
        System.out.println("Historia em uma ilha" + descrisao);
        System.out.println("Duração: "+ tempo);
        System.out.println("Diretor: " + diretor);

    }

}
