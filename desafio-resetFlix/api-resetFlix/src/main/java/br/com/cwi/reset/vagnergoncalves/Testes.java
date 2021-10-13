package br.com.cwi.reset.vagnergoncalves;

import domain.Ator;
import domain.Diretor;
import domain.StatusCarreira;
import request.AtorRequest;
import request.DiretorRequest;
import service.AtorService;
import service.DiretorService;

import java.time.LocalDate;
import java.util.List;

public class Testes {
    public static void main(String[] args) throws Exception {
        FakeDatabase fakeDatabase = new FakeDatabase();
        AtorService atorService = new AtorService(fakeDatabase);
        DiretorService diretorService = new DiretorService(fakeDatabase);

        AtorRequest atorRequest = new AtorRequest("Vagner", LocalDate.of(1992, 12, 10), StatusCarreira.EM_ATIVIDADE,
                2005);
        atorService.criarAtor(atorRequest);

        AtorRequest atorRequest1 = new AtorRequest("Vagninho", LocalDate.of(1992, 12, 10), StatusCarreira.EM_ATIVIDADE, 2005);
        atorService.criarAtor(atorRequest1);
        System.out.println("---------------");

        List<Ator> atores = fakeDatabase.recuperaAtores();
        System.out.println(atores);

        System.out.println("---------------");

        DiretorRequest diretorRequest = new DiretorRequest("Pedro Direto", LocalDate.of(1988, 10, 10), 2005);
        diretorService.criarDiretor(diretorRequest);

        DiretorRequest diretor2 = new DiretorRequest("Pedão Alves",LocalDate.of(1965,2,2),2002);
        diretorService.criarDiretor(diretor2);

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        System.out.println(diretores);

        System.out.println("---------------");
    }
}
