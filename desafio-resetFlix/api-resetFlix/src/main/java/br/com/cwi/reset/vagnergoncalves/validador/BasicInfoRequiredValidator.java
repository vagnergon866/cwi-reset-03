package br.com.cwi.reset.vagnergoncalves.validador;

import br.com.cwi.reset.vagnergoncalves.domain.*;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.request.PersonagemRequest;

import java.time.LocalDate;
import java.util.List;

public class BasicInfoRequiredValidator {


    //ator,diretor
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

    //estudio
    public void accept(String nome, LocalDate dataCriacao, StatusAtividade statusAtividade) throws Exception {
        if (nome == null) {
            throw new NomeNaoInformadoException();
        }
        if (dataCriacao == null) {
            throw new DescricaoNaoInformadaException();
        }
        if (statusAtividade == null) {
            throw new StatusAtividadeNaoInformadoException();
        }
        if (LocalDate.now().isBefore(dataCriacao)) {
            throw new EstudioDoFuturoException();
        }
    }

    // filme
    public void accept(String nome, Integer anoLancamento, String capaFilme,
                       List<Genero> generos, Integer idDiretor, Integer idEstudio, String resumo, List<PersonagemRequest> personagens) throws Exception {
        if (nome == null) {
            throw new NomeNaoInformadoException();
        }
        if (anoLancamento == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }
        if (capaFilme == null) {
            throw new CapaDoFilmeNaoInformadoException();
        }
        if (generos == null || generos.isEmpty()) {
            throw new GeneroNaoInformadoException();

        }
        if (idDiretor == null) {
            throw new IdNaoInformado();
        }
        if (idEstudio == null) {
            throw new IdNaoInformado();
        }
        if (resumo == null) {
            throw new ResumoNaoInformadoException();
        }
        if (personagens == null || personagens.isEmpty()) {
            throw new PersonagemNaoInformadoException();
        }

    }

    public void accept(String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) throws Exception {

        if (nomePersonagem == null) {
            throw new NomeNaoInformadoException();
        }
        if (descricaoPersonagem == null) {
            throw new DescricaoNaoInformadaException();
        }
        if (tipoAtuacao == null){
            throw new TipoAtuacaoNaoInformadaException();
        }
    }

}
