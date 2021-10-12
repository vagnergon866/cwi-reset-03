package br.com.cwi.reset.vagnergoncalves;

import java.util.ArrayList;
import java.util.List;

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
    public Integer gerarId(){
        return ++versionadorId;
    }
}
