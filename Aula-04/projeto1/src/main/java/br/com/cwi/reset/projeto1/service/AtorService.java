package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;


    public Ator salvar(Ator ator){
        return repository.save(ator);
    }

    public void consultapeloNome(String nome){
        Ator ator = repository.findByNome(nome);
    }


    }
}
