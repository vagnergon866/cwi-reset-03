package br.com.cwi.reset.vagnergoncalves.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltrosNaoEncontradosFilmeException extends Exception {

    public FiltrosNaoEncontradosFilmeException(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) {
        super("Filme não encontrado com os filtros nomeFilme=" + nomeFilme +
                ", nomeDiretor=" + nomeDiretor +
                ", nomePersonagem=" + nomePersonagem +
                ", nomeAtor=" + nomeAtor +
                ", favor informar outros filtros.");
    }
}
