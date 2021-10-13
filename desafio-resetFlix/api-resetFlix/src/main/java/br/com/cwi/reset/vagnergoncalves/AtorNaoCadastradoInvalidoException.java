package br.com.cwi.reset.vagnergoncalves;

public class AtorNaoCadastradoInvalidoException extends Exception{

    public AtorNaoCadastradoInvalidoException(){
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
