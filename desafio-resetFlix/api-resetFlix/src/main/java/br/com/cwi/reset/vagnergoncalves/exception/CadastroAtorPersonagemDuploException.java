package br.com.cwi.reset.vagnergoncalves.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroAtorPersonagemDuploException extends  Exception{

    public CadastroAtorPersonagemDuploException(){
        super("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
    }
}
