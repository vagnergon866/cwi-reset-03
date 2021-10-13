package exception;

public class AtorNaoCadastradoInvalidoException extends Exception{

    public AtorNaoCadastradoInvalidoException(){
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
