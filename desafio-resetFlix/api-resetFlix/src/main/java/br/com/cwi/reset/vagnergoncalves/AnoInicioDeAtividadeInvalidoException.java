package br.com.cwi.reset.vagnergoncalves;

public class AnoInicioDeAtividadeInvalidoException extends Exception{

    public AnoInicioDeAtividadeInvalidoException(){
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
