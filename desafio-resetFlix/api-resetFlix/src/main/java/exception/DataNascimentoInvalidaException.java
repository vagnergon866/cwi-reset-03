package exception;

public class DataNascimentoInvalidaException extends Exception {

    public DataNascimentoInvalidaException(){
        super("Não é possível cadastrar Atores ou Diretores não nascidos.");
    }
}
