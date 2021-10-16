package br.com.reset.primeiroprojetospring.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/filme")
public class FilmeControler {

    @GetMapping
    public Filme filme(){
        return new Filme("Caverna do Dragão","É um filme de animação.",150,1980, 5.0,
                new Diretor("Joãozinho", LocalDate.of(1945,05,12),15,Genero.MASCULINO));
    }

}
