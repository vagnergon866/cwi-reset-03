package exception;

public class ComMesmoNomeInvalidoException extends Exception{


    public ComMesmoNomeInvalidoException(String nome){
        super("Já existe um Ator ou Diretor cadastrado para o nome " + nome + ".");
    }
}
