package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.repositoty.EstudioRepository;
import br.com.cwi.reset.vagnergoncalves.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Objects.isNull;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        Estudio estudio = estudioRequest.converteObjeto();

        List<Estudio> estudiosCadastrados = this.estudioRepository.findAll();

        for (Estudio estudioCadastrado : estudiosCadastrados) {
            if (estudioCadastrado.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO,
                        "Já existe um estúdio cadastrado para o nome " + estudioRequest.getNome());
            }
        }
        this.estudioRepository.save(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
         List<Estudio> estudiosCadastrados = this.estudioRepository.findAll();
         List<Estudio> estudios = new ArrayList<>();

        if (estudiosCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
        }

        if (!isNull(filtroNome)) {
            for (Estudio estudio : estudiosCadastrados) {
                if (estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                    estudios.add(estudio);
                }
            }
        } else {
            estudios.addAll(estudiosCadastrados);
        }
        List<Estudio> retorno = estudioRepository.findByNomeContainingIgnoreCase(filtroNome);
        if (estudios.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Estúdio", filtroNome);
        }

        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {
        if (isNull(id)) {
            throw new IdNaoInformado();
        }

        return this.estudioRepository.findAll()
                .stream().filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ConsultaIdInvalidoException(
                                TipoDominioException.ESTUDIO.getSingular(),
                                id));
    }
}
