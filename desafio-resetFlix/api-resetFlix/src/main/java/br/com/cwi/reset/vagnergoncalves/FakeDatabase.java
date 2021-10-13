package br.com.cwi.reset.vagnergoncalves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FakeDatabase {

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
    private Integer versionadorId = 0;

    public void persisteAtor(Ator ator) {
        ator.setId(gerarId());
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }

    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }

    public Integer gerarId() {
        return ++versionadorId;
    }

    public List<AtorEmAtividade> filtraAtorEmAtividade(Optional<String> filtroNome) {
        return atores.stream().filter(a -> filtroNome.isPresent() ? a.getNome().equals(filtroNome.get()) : true)
                .filter(a -> a.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                .map(a -> new AtorEmAtividade(a.getId(), a.getNome(), a.getDataNascimento()))
                .collect(Collectors.toList());

    }

    public Optional<Ator> consultaTodosAtores(Integer id) {
        return atores.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public List<Ator> buscaTodosAtores() {
        return atores.stream().collect(Collectors.toList());

    }


}
