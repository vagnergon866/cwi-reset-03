package filmes;

import diretor.Diretor;
import exception.AvaliacaoForaDoPadraoException;

public class Filmes {

    private String nome;
    private String descrisao;
    private Integer tempo;
    private Integer anoLancamento;
    private Double avaliacao;
    private Diretor diretor;

    public Filmes(String nome, String descrisao, Integer tempo, Integer anoLancamento, Double avaliacao, Diretor diretor)throws AvaliacaoForaDoPadraoException {
        if(avaliacao < 1.0 || avaliacao > 5.0){
            throw new AvaliacaoForaDoPadraoException();
        }
        this.nome = nome;
        this.descrisao = descrisao;
        this.tempo = tempo;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Filme: " + nome);
        System.out.println("Descrição: " + descrisao);
        System.out.println("Duração: " + tempo);
        System.out.println("Avalição: " + avaliacao);
        System.out.println("Diretor: " + diretor.getNome());

    }

}
