package service;

import domain.Ator;
import domain.AtorEmAtividade;
import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import domain.StatusCarreira;
import exception.*;
import request.AtorRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest)throws Exception {
        camposObrigatorios(atorRequest);
        validaDataNascimento(atorRequest);
        validaSobrenome(atorRequest);
        validaAnoInicioDeAtividade(atorRequest);
        validaNomeUnicoAtor(atorRequest);

        Ator DtoAtor = atorAdapter(atorRequest);
        fakeDatabase.persisteAtor(DtoAtor);
    }

    private Ator atorAdapter(AtorRequest atorRequest) {
        Ator ator = new Ator(atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade());
        return ator;
    }

    private void camposObrigatorios(AtorRequest atorRequest) throws CamposInvalidosException {
        String nome = atorRequest.getNome();
        LocalDate dataNascimento = atorRequest.getDataNascimento();
        StatusCarreira statusCarreira = atorRequest.getStatusCarreira();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();
        String campo;
        if (nome == null) {
            campo = "Nome";
            throw new CamposInvalidosException(campo);
        }
        if (dataNascimento == null) {
            campo = "Data de Nascimento";
            throw new CamposInvalidosException(campo);
        }
        if (statusCarreira == null) {
            campo = "Status Carreira";
            throw new CamposInvalidosException(campo);
        }
        if (anoInicioAtividade == null) {
            campo = "Ano Inicio Atividade";
            throw new CamposInvalidosException(campo);
        }
    }

    private void validaDataNascimento(AtorRequest atorRequest) throws DataNascimentoInvalidaException {
        Integer anoAtual = LocalDate.now().getYear();
        Integer anoNascimentoAtor = atorRequest.getDataNascimento().getYear();
        if (anoNascimentoAtor > anoAtual) {
            throw new DataNascimentoInvalidaException();
        }
    }

    private void validaSobrenome(AtorRequest atorRequest) throws NomeSobrenomeInvalidoException {
        String[] nomeSobrenome = atorRequest.getNome().split("");
        if (nomeSobrenome.length < 2) {
            throw new NomeSobrenomeInvalidoException();
        }
    }

    private void validaAnoInicioDeAtividade(AtorRequest atorRequest) throws AnoInicioDeAtividadeInvalidoException {
        Integer anoNascimentoAtor = atorRequest.getDataNascimento().getYear();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();
        if (anoInicioAtividade < anoNascimentoAtor) {
            throw new AnoInicioDeAtividadeInvalidoException();
        }
    }

    private void validaNomeUnicoAtor(AtorRequest atorRequest) throws ComMesmoNomeInvalidoException {
        String nomeDoAtor = atorRequest.getNome();
        List<Ator> atores = fakeDatabase.recuperaAtores();
        for (Ator ator : atores) {
            if (ator.getNome().equals(nomeDoAtor)) {
                throw new ComMesmoNomeInvalidoException(nomeDoAtor);
            }
        }
    }

    public List<AtorEmAtividade> listarAtorEmAtividade(Optional<String> filtroNome) throws AtorNaoCadastradoInvalidoException, FiltroNomeAtorInvalidoException {
        Integer listaAtualDeAtores = fakeDatabase.recuperaAtores().size();
        if (listaAtualDeAtores == 0) {
            throw new AtorNaoCadastradoInvalidoException();
        }
        List<AtorEmAtividade> resultado = fakeDatabase.filtraAtorEmAtividade(filtroNome);
        System.out.println(resultado.size());
        if (resultado.isEmpty()) {
            String filtro = filtroNome.map(Objects::toString).orElse(null);
            throw new FiltroNomeAtorInvalidoException(filtro);
        }
        return resultado;
    }

    public Optional<Ator> consultarAtor(Integer id) throws CamposInvalidosException, IdInvalidoException {
        if (id == null) {
            throw new CamposInvalidosException("id");
        }
        Optional<Ator> atorEncontrado = fakeDatabase.consultaTodosAtores(id);
        if (atorEncontrado.isPresent()) {
            throw new IdInvalidoException("ator", id);
        }
        return atorEncontrado;
    }

    public List<Ator> consultaAtores() throws AtorNaoCadastradoInvalidoException {
        List<Ator> atores = fakeDatabase.recuperaAtores();
        if (atores.isEmpty()) {
            throw new AtorNaoCadastradoInvalidoException();
        }
        return atores;
    }


}