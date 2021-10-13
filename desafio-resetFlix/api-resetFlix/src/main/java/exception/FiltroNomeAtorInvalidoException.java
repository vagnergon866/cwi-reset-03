package exception;

public class FiltroNomeAtorInvalidoException extends Exception{

    public FiltroNomeAtorInvalidoException(String filtro){
        super("Ator não encontrado com o filtro " + filtro + ", favor informar outro filtro.");
    }
}
