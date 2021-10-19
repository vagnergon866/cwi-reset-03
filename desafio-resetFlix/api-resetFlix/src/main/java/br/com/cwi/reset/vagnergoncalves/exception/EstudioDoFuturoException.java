package br.com.cwi.reset.vagnergoncalves.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstudioDoFuturoException extends Exception{
    public EstudioDoFuturoException(){
        super("Não é possível cadastrar estúdios do futuro.");
    }

}
