package br.com.cwi.reset.vagnergoncalves.validador;

import br.com.cwi.reset.vagnergoncalves.exception.DescricaoPersonagemNaoInformadaException;
import br.com.cwi.reset.vagnergoncalves.exception.IdAtorNaoInformadoException;
import br.com.cwi.reset.vagnergoncalves.exception.TipoAtuacaoNaoInformadoException;
import br.com.cwi.reset.vagnergoncalves.request.PersonagemRequest;

import static java.util.Objects.isNull;

public class PersonagemRequestCamposObrigatoriosValidator {

    public void accept(final PersonagemRequest personagemRequest) throws Exception {
//        if (isNull(personagemRequest.getNomePersonagem())) {
//            throw new NomeNaoInformadoException();
//        }

        if (isNull(personagemRequest.getDescricaoPersonagem())) {
            throw new DescricaoPersonagemNaoInformadaException();
        }

        if (isNull(personagemRequest.getIdAtor())) {
            throw new IdAtorNaoInformadoException();
        }

        if (isNull(personagemRequest.getTipoAtuacao())) {
            throw new TipoAtuacaoNaoInformadoException();
        }
    }
}
