package exception;

public class IdInvalidoException extends Exception{

    public IdInvalidoException(String atorOuDiretor, Integer id){
        super("Nenhum " + atorOuDiretor + " encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
    }

}
