package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorService service = new AtorService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ator cadastrarPet(@RequestBody Pet pet)  {
        return service.salvar(ator);
    }
}
