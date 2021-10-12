package br.com.cwi.reset.vagnergoncalves;

import java.time.LocalDate;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) {
        Ator DtoAtor = atorAdapter(atorRequest);
        fakeDatabase.persisteAtor(DtoAtor);
    }

    private Ator atorAdapter(AtorRequest atorRequest) {
        Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade());
        return ator;
    }

}