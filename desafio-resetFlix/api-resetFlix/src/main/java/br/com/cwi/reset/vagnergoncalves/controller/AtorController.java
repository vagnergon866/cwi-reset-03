package br.com.cwi.reset.vagnergoncalves.controller;


import br.com.cwi.reset.vagnergoncalves.domain.Ator;
import br.com.cwi.reset.vagnergoncalves.response.AtorEmAtividade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.cwi.reset.vagnergoncalves.request.AtorRequest;
import br.com.cwi.reset.vagnergoncalves.service.AtorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService service;

    @PostMapping
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        this.service.criarAtor(atorRequest);
    }

//    @GetMapping("/em_atividade")
//    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome) throws Exception {
//        return this.service.listarAtoresEmAtividade(filtroNome);
//    }
//
//    @GetMapping("/{id}")
//    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
//        return this.service.consultarAtor(id);
//    }
//
//    @GetMapping
//    public List<Ator> consultarAtores() throws Exception {
//        return this.service.consultarAtores();
//    }



}