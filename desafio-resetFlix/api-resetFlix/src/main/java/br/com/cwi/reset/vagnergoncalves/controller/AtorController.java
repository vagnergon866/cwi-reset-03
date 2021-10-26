package br.com.cwi.reset.vagnergoncalves.controller;


import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.response.AtorEmAtividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.cwi.reset.vagnergoncalves.request.AtorRequest;
import br.com.cwi.reset.vagnergoncalves.service.AtorService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping(path = "/em_atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome) throws Exception{
        return this.atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping(value = "/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
        return this.atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> consultarAtores() throws Exception {
        return this.atorService.consultarAtores();
    }



}