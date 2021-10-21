package br.com.cwi.reset.vagnergoncalves.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonagemNaoInformadoException extends CampoNaoInformadoException{

    public PersonagemNaoInformadoException(){
        super("personagem");
    }
}
