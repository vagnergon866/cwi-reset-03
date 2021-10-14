package service;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import domain.Diretor;
import exception.*;
import request.DiretorRequest;

import java.time.LocalDate;
import java.util.List;


public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarDiretor(DiretorRequest diretorRequest) {
        Diretor DtoDiretor = diretorAdapter(diretorRequest);
        fakeDatabase.persisteDiretor(DtoDiretor);
    }

    private Diretor diretorAdapter(DiretorRequest diretorRequest) {
        Diretor diretor = new Diretor(diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade());
        return diretor;
    }


    private void camposObrigatorios(DiretorRequest diretorRequest) throws CamposInvalidosException {
        String nome = diretorRequest.getNome();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();
        String campo;
        if (nome == null) {
            campo = "Nome";
            throw new CamposInvalidosException(campo);
        }
        if (dataNascimento == null) {
            campo = "Data de Nascimento";
            throw new CamposInvalidosException(campo);
        }
        if (anoInicioAtividade == null) {
            campo = "Ano Inicio Atividade";
            throw new CamposInvalidosException(campo);
        }
    }

    private void validaSobrenome(DiretorRequest diretorRequest) throws NomeSobrenomeInvalidoException {
        String[] nomeSobrenome = diretorRequest.getNome().split("");
        if (nomeSobrenome.length < 2) {
            throw new NomeSobrenomeInvalidoException();
        }
    }

    private void validaDataNascimento(DiretorRequest diretorRequest) throws DataNascimentoInvalidaException {
        Integer anoAtual = LocalDate.now().getYear();
        Integer anoNascimentoDiretor = diretorRequest.getDataNascimento().getYear();
        if (anoNascimentoDiretor > anoAtual) {
            throw new DataNascimentoInvalidaException();
        }
    }

    private void validaAnoInicioDeAtividade(DiretorRequest diretorRequest) throws AnoInicioDeAtividadeInvalidoException {
        Integer anoNascimentoDiretor = diretorRequest.getDataNascimento().getYear();
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();
        if (anoInicioAtividade < anoNascimentoDiretor) {
            throw new AnoInicioDeAtividadeInvalidoException();
        }
    }

    private void validaNomeUnicoDiretor(DiretorRequest diretorRequest) throws ComMesmoNomeInvalidoException {
        String nomeDiretor = diretorRequest.getNome();
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equals(nomeDiretor)) {
                throw new ComMesmoNomeInvalidoException(nomeDiretor);
            }
        }
    }
    


}