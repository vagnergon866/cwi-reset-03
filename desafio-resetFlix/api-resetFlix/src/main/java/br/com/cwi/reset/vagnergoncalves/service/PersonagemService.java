package br.com.cwi.reset.vagnergoncalves.service;


import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.domain.PersonagemAtor;
import br.com.cwi.reset.vagnergoncalves.exception.CadastroPersonagemAtorDuplicadoException;
import br.com.cwi.reset.vagnergoncalves.repositoty.PersonagemRepository;
import br.com.cwi.reset.vagnergoncalves.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private AtorService atorService;

    public List<PersonagemAtor> criarPersonagemAtor(List<PersonagemRequest> personagemRequest) throws Exception {

        List<PersonagemAtor> personagensAtores = new ArrayList<>();
        List<String> idsAtorPersonagem = new ArrayList<>();

        for (PersonagemRequest p : personagemRequest ){
            Integer id = p.getIdAtor();
            String isdAtorNomePersonagem = id.toString() + p.getNomePersonagem();

            idsAtorPersonagem.add(isdAtorNomePersonagem);

            Integer frequenciaId = Collections.frequency(idsAtorPersonagem, isdAtorNomePersonagem);
            if (frequenciaId > 1){
                throw new CadastroPersonagemAtorDuplicadoException();
            }
            Ator ator = atorService.consultarAtor(id);
            PersonagemAtor personagemAtor = new PersonagemAtor(ator,
                                                               p.getNomePersonagem(),
                                                               p.getDescricaoPersonagem(),
                                                               p.getTipoAtuacao());
            personagensAtores.add(personagemAtor);
            personagemRepository.save(personagemAtor);
        }

        return personagensAtores;
    }
    public Boolean atorComPersonagem(Integer idAtor){
        List<PersonagemAtor> atores = personagemRepository.findByAtorIdEquals(idAtor);

        Boolean atorContemPersonagem = false;
        if(!atores.isEmpty()){
            atorContemPersonagem = true;
        }
        return atorContemPersonagem;
    }

    public void removerPersonagens(List<PersonagemAtor> personagemAtores){
        personagemRepository.deleteAll(personagemAtores);
    }

 }
