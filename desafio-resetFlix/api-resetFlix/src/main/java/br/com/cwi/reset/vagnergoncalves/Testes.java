package br.com.cwi.reset.vagnergoncalves;

import domain.Ator;
import domain.StatusCarreira;
import request.AtorRequest;
import service.AtorService;

import java.time.LocalDate;
import java.util.List;

public class Testes {
    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        AtorService atorService = new AtorService(fakeDatabase);

        AtorRequest atorRequest = new AtorRequest( "Vagner",LocalDate.of(1992,12,10), StatusCarreira.EM_ATIVIDADE,
                2005);
        atorService.criarAtor(atorRequest);
        AtorRequest atorRequest1 = new AtorRequest("Vagninho", LocalDate.of(1992,12,10),StatusCarreira.EM_ATIVIDADE,
                2005);
        atorService.criarAtor(atorRequest1);

        List<Ator> atores = fakeDatabase.recuperaAtores();
        System.out.println(atores);
    }
}
