package br.com.cwi.reset.vagnergoncalves.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroDuplicadoException extends Exception{
    public CadastroDuplicadoException(TipoDominioException ator, String message) {
        super(message);
    }


}
