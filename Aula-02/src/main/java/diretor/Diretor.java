package diretor;

public class Diretor  {
    private String nome;
    private Integer idade;
    private  Integer quantidadeDeFilmes;

    public Diretor(String nome, Integer idade, Integer quantidadeDeFilmes){
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmes = quantidadeDeFilmes;
    }

  public String getNome(){
        return nome;
  }
}
