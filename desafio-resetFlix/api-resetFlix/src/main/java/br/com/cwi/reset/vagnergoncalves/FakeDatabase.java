package br.com.cwi.reset.vagnergoncalves;

import domain.Ator;
import domain.AtorEmAtividade;
import domain.Diretor;
import domain.StatusCarreira;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FakeDatabase {

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
    private Integer contadorIdAtor = 0;
    private Integer contadorIdDiretor = 0;

    public void persisteAtor(Ator ator) {
        ator.setId(gerarIdAtor());
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }

    public void persisteDiretor(Diretor diretor) {
        diretor.setId(gerarIdDiretor());
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }

    public Integer gerarIdAtor() {
        return ++contadorIdAtor;
    }

    public Integer gerarIdDiretor() {
        return ++contadorIdDiretor;
    }

    public List<AtorEmAtividade> filtraAtorEmAtividade(Optional<String> filtroNome) {
        return atores.stream()  .filter(a -> filtroNome.isPresent() ? a.getNome().equals(filtroNome.get()) : true)
                .filter(a -> a.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                .map(a -> new AtorEmAtividade(a.getId(), a.getNome(), a.getDataNascimento()))
                .collect(Collectors.toList());

    }

    public Optional<Ator> consultaTodosAtoresId(Integer id) {
        return atores.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public List<Ator> buscaTodosAtores() {
        return atores.stream().collect(Collectors.toList());

    }
    public List<Diretor> listaDiretor(Optional<String> filtrarNome){
        return diretores.stream().filter(d -> filtrarNome.isPresent() ? d.getNome().equals(filtrarNome.get()) : true)
                .collect(Collectors.toList());
    }
    public Optional<Diretor> consultaTodosDiretoresId(Integer id){
        return diretores.stream().filter(d -> d.getId().equals(id) ).findFirst();
    }



}
