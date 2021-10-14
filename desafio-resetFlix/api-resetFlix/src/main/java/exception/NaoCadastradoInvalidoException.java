package exception;

public class NaoCadastradoInvalidoException extends Exception{

    public NaoCadastradoInvalidoException(){
        super("Nenhum Ator ou Diretor cadastrado, favor cadastar Atores ou Diretores.");
    }
}
