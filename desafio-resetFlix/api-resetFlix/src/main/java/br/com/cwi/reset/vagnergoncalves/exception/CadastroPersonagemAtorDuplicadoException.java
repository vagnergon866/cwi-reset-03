package br.com.cwi.reset.vagnergoncalves.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroPersonagemAtorDuplicadoException extends Exception{

    public CadastroPersonagemAtorDuplicadoException(){
        super("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
    }
}
