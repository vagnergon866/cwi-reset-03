package exception;

public class IdInvalidoException extends Exception{

    public IdInvalidoException( Integer id){
        super("Nenhum  Ator ou Diretor encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
    }

}
