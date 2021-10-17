package exception;

public class FiltroNomeNaoEncontrado extends Exception{
    public FiltroNomeNaoEncontrado(String tipo, String parametro){
        super(String.format("%s não encontrato com o filtro %s, favor informar outro filtro.", tipo, parametro));
    }
}
