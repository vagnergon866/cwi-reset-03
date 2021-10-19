package br.com.cwi.reset.vagnergoncalves.controller;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.domain.AtorEmAtividade;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.cwi.reset.vagnergoncalves.request.AtorRequest;
import br.com.cwi.reset.vagnergoncalves.service.AtorService;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em_atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome) throws Exception {
        return this.atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
        return this.atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> consultarAtores() throws Exception {
        return this.atorService.consultarAtores();
    }



}