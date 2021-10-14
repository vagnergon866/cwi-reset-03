package exception;

public class AtorNaoCadastradoInvalidoException extends Exception{

    public AtorNaoCadastradoInvalidoException(){
        super("Nenhum Ator ou Diretor cadastrado, favor cadastar Atores ou Diretores.");
    }
}
