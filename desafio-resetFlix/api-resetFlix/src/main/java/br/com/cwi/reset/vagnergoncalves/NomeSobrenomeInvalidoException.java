package br.com.cwi.reset.vagnergoncalves;

public class NomeSobrenomeInvalidoException extends Exception {

    public NomeSobrenomeInvalidoException(){
        super("Deve ser informado no mínimo nome e sobrenome para o ator.");
    }
}
