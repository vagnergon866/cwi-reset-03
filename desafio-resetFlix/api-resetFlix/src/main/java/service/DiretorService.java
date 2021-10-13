package service;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import domain.Diretor;
import request.DiretorRequest;

import java.time.LocalDate;


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

    private void validaDataNascimento(DiretorRequest diretorRequest) {
        Integer anoAtual = LocalDate.now().getYear();
        Integer anoNascimentoAtor = diretorRequest.getDataNascimento().getYear();

    }

}