package exception;

public class AnoInicioDeAtividadeInvalidoException extends Exception{

    public AnoInicioDeAtividadeInvalidoException(){
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
