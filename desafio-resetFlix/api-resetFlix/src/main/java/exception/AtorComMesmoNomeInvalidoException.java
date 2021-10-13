package exception;

public class AtorComMesmoNomeInvalidoException extends Exception{


    public AtorComMesmoNomeInvalidoException(String nome){
        super("Já existe um ator cadastrado para o nome " + nome + ".");
    }
}
