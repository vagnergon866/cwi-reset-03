package br.com.cwi.reset.vagnergoncalves.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeNaoInformadoException extends CampoNaoInformadoException{
    public NomeNaoInformadoException(){
        super("nome");
    }
}