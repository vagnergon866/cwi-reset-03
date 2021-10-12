package br.com.cwi.reset.vagnergoncalves;

public class CamposInvalidosException extends Exception {

    public CamposInvalidosException(String campo) {
        super("Campo obrigatório não informado. Favor informar o campo " + campo + ".");
    }

}

