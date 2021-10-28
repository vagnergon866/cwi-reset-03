package br.com.cwi.reset.vagnergoncalves.service;

import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
import br.com.cwi.reset.vagnergoncalves.exception.*;
import br.com.cwi.reset.vagnergoncalves.repositoty.EstudioRepository;
import br.com.cwi.reset.vagnergoncalves.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

            Estudio estudiosCadastrados = estudioRepository.findByNomeEqualsIgnoreCase(estudioRequest.getNome());
            if(estudiosCadastrados != null){
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(),estudioRequest.getNome());
            }

            Estudio estudio = new Estudio(
                    estudioRequest.getNome(),
                    estudioRequest.getDescricao(),
                    estudioRequest.getDataCriacao(),
                    estudioRequest.getStatusAtividade());

            estudioRepository.save(estudio);
        }

        public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
            if(estudioRepository.count() == 0){
                throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
            }

            List<Estudio> resultado = estudioRepository.findByNomeContainingIgnoreCase(filtroNome);
            if (resultado.isEmpty()) {
                throw new FiltroNomeNaoEncontrado("Estudio", filtroNome);
            }
            return resultado;
        }

        public Estudio consultarEstudio(Integer id) throws Exception {
            return estudioRepository.findById(id)
                    .orElseThrow(()-> new ConsultaIdInvalidoException(TipoDominioException.ESTUDIO.getSingular(), id));
        }
}
