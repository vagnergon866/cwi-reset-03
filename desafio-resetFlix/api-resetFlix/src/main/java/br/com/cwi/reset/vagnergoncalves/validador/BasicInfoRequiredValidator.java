package br.com.cwi.reset.vagnergoncalves.validador;

import br.com.cwi.reset.vagnergoncalves.domain.StatusAtividade;
import br.com.cwi.reset.vagnergoncalves.exception.*;

import java.time.LocalDate;

public class BasicInfoRequiredValidator {

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade,
                       final TipoDominioException tipoDominioException) throws Exception {
        if (nome == null) {
            throw new NomeNaoInformadoException();
        }
        if (dataNascimento == null) {
            throw new DataNascimentoNaoInformadoException();
        }
        if (anoInicioAtividade == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }
        if (nome.split("").length < 2) {
            throw new NomeSobrenomeObrigatorioException(tipoDominioException.getSingular());
        }
        if (LocalDate.now().isBefore(dataNascimento)) {
            throw new NascidosNoFuturoException(tipoDominioException.getPlural());
        }
        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new AnoInicioAtividadeInvalidoException(tipoDominioException.getSingular());
        }

    }

    public void accept(String nome, LocalDate dataCriacao, StatusAtividade statusAtividade) throws Exception {
        if(nome == null){
            throw new NomeNaoInformadoException();
        }
        if(dataCriacao == null){
            throw new DescricaoNaoInformadaException();
        }
        if(statusAtividade == null){
            throw new StatusAtividadeNaoInformadoException();
        }
        if (LocalDate.now().isBefore(dataCriacao)) {
            throw new EstudioDoFuturoException();
        }
    }
}
