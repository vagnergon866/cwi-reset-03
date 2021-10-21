package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.domain.PersonagemAtor;
import br.com.cwi.reset.vagnergoncalves.exception.CadastroAtorPersonagemDuploException;
import br.com.cwi.reset.vagnergoncalves.request.PersonagemRequest;
import br.com.cwi.reset.vagnergoncalves.validador.BasicInfoRequiredValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonagemService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    public List<PersonagemAtor> criarPersonagem(List<PersonagemRequest> personagemRequest) throws Exception {

        List<PersonagemAtor> personagemAtores = new ArrayList<>();
        List<String> idsAtorPersonagem = new ArrayList<>();

        for (PersonagemRequest personagem : personagemRequest) {
            new BasicInfoRequiredValidator().accept(personagem.getNomePersonagem(), personagem.getDescricaoPersonagem(),personagem.getTipoAtuacao());
            Integer id = personagem.getIdAtor();
            String idAtorNomePersonagem = id.toString() + personagem.getNomePersonagem();

            idsAtorPersonagem.add(idAtorNomePersonagem);

            Integer frequenciaIdAtorPersonagem = Collections.frequency(idsAtorPersonagem, idAtorNomePersonagem);
            if (frequenciaIdAtorPersonagem > 1) {
                throw new CadastroAtorPersonagemDuploException();
            }
            Integer idGerado = fakeDatabase.recuperaPersonagens().size() + 1;
            Ator ator = atorService.consultarAtor(id);
            PersonagemAtor personagemAtor = new PersonagemAtor(idGerado, ator, personagem.getNomePersonagem(),
                    personagem.getDescricaoPersonagem(), personagem.getTipoAtuacao());

            personagemAtores.add(personagemAtor);
            fakeDatabase.persistePersonagem(personagemAtor);

        }
        return personagemAtores;

    }
}
