package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.request.EstudioRequest;
import br.com.cwi.reset.vagnergoncalves.validador.BasicInfoRequiredValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        new BasicInfoRequiredValidator().accept(estudioRequest.getNome(),
                estudioRequest.getDataCriacao(),
                estudioRequest.getStatusAtividade());

        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        for (Estudio estudio : estudiosCadastrados) {
            if (estudio.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.Estudio.getSingular(), TipoDominioException.Estudio.getPlural());
            }
        }
        final Integer idGerado = estudiosCadastrados.size() + 1;

        final Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(),
                estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(),
                estudioRequest.getStatusAtividade());

        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
        List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        if (estudiosCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.Estudio.getSingular(), TipoDominioException.Estudio.getPlural());
        }
        List<Estudio> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Estudio estudio : estudiosCadastrados) {
                final boolean containsFilter = estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(estudio);
                }
            }
        } else {
            retorno.addAll(estudiosCadastrados);
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Estudio", filtroNome);
        }
        return retorno;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }
        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        for (Estudio estudio : estudios) {
            if (estudio.getId().equals(id)) {
                return estudio;
            }
        }
        throw new ConsultaIdInvalidoException(TipoDominioException.Estudio.getSingular(), id);
    }

}
