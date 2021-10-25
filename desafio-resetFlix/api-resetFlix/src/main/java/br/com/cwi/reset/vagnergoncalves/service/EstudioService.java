//package br.com.cwi.reset.vagnergoncalves.service;
//
//
//import br.com.cwi.reset.vagnergoncalves.FakeDatabase;
//import br.com.cwi.reset.vagnergoncalves.domain.Estudio;
//import br.com.cwi.reset.vagnergoncalves.exception.*;
//import br.com.cwi.reset.vagnergoncalves.request.EstudioRequest;
//import br.com.cwi.reset.vagnergoncalves.validador.EstudioRequestCamposObrigatoriosValidator;
//
//import java.time.LocalDate;
//import java.util.*;
//
//import static java.util.Objects.isNull;
//
//public class EstudioService {
//
//    private FakeDatabase fakeDatabase;
//
//    public EstudioService(final FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;
//    }
//
//    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
//        new EstudioRequestCamposObrigatoriosValidator().accept(estudioRequest);
//
//        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();
//
//        for (Estudio estudioCadastrado : estudiosCadastrados) {
//            if (estudioCadastrado.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
//                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudioRequest.getNome());
//            }
//        }
//
//        if (LocalDate.now().isBefore(estudioRequest.getDataCriacao())) {
//            throw new CanseiDeCriarExceptionCustomizadaException("Não é possível cadastrar estúdios do futuro.");
//        }
//
//        final Integer idGerado = estudiosCadastrados.size() + 1;
//
//        final Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());
//
//        fakeDatabase.persisteEstudio(estudio);
//    }
//
//    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
//        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();
//        final List<Estudio> estudios = new ArrayList<>();
//
//        if (estudiosCadastrados.isEmpty()) {
//            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
//        }
//
//        if (!isNull(filtroNome)) {
//            for (Estudio estudio : estudiosCadastrados) {
//                if (estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
//                    estudios.add(estudio);
//                }
//            }
//        } else {
//            estudios.addAll(estudiosCadastrados);
//        }
//
//        if (estudios.isEmpty()) {
//            throw new FiltroNomeNaoEncontrado("Estúdio", filtroNome);
//        }
//
//        return estudios;
//    }
//
//    public Estudio consultarEstudio(Integer id) throws Exception {
//        if (isNull(id)) {
//            throw new IdNaoInformado();
//        }
//
//        return fakeDatabase.recuperaEstudios()
//                .stream().filter(e -> e.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() ->
//                        new ConsultaIdInvalidoException(
//                                TipoDominioException.ESTUDIO.getSingular(),
//                                id)
//                );
//    }
//}
