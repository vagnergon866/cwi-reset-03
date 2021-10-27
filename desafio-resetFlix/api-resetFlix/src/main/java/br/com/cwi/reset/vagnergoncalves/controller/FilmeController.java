package br.com.cwi.reset.vagnergoncalves.controller;

import br.com.cwi.reset.vagnergoncalves.domain.Filme;
import br.com.cwi.reset.vagnergoncalves.request.FilmeRequest;
import br.com.cwi.reset.vagnergoncalves.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody @Valid FilmeRequest filmeRequest) throws Exception {
        this.filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    public List<Filme> consultarFilmes(
            @RequestParam String nomeFilme,
            @RequestParam String nomeDiretor,
            @RequestParam String nomePersonagem,
            @RequestParam String nomeAtor) throws Exception {
        return this.filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }
}
