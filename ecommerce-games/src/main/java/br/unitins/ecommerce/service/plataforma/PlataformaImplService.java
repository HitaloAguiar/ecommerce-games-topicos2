package br.unitins.ecommerce.service.plataforma;

import java.util.List;
import java.util.Set;

import br.unitins.ecommerce.dto.PlataformaDTO;
import br.unitins.ecommerce.model.produto.Plataforma;
import br.unitins.ecommerce.repository.FabricanteRepository;
import br.unitins.ecommerce.repository.PlataformaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PlataformaImplService implements PlataformaService {

    @Inject
    Validator validator;

    @Inject
    PlataformaRepository plataformaRepository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    public List<Plataforma> getAll() {
        
        return plataformaRepository.findAll().list();
    }

    @Override
    public Plataforma getById(Long id) {
        
        Plataforma plataforma = plataformaRepository.findById(id);

        if (plataforma == null)
            throw new NotFoundException("Não encontrado");

        return plataforma;
    }

    @Override
    @Transactional
    public Plataforma insert(PlataformaDTO plataformaDTO) {
        
        validar(plataformaDTO);

        Plataforma plataforma = new Plataforma();

        plataforma.setNome(plataformaDTO.nome());

        plataforma.setDescricao(plataformaDTO.descricao());

        plataforma.setAnoLancamento(plataformaDTO.anoLancamento());

        plataforma.setFabricante(fabricanteRepository.findById(plataformaDTO.fabricante()));

        plataformaRepository.persist(plataforma);

        return plataforma;
    }

    @Override
    @Transactional
    public Plataforma update(Long id, PlataformaDTO plataformaDTO) {
        
        validar(plataformaDTO);

        Plataforma plataforma = plataformaRepository.findById(id);

        if (plataforma == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        plataforma.setNome(plataformaDTO.nome());

        plataforma.setDescricao(plataformaDTO.descricao());

        plataforma.setAnoLancamento(plataformaDTO.anoLancamento());

        plataforma.setFabricante(fabricanteRepository.findById(plataformaDTO.fabricante()));

        return plataforma;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Plataforma plataforma = plataformaRepository.findById(id);

        if (plataformaRepository.isPersistent(plataforma))
            plataformaRepository.delete(plataforma);

        else
            throw new NotFoundException("Nenhuma plataforma encontrado");
    }
    
    private void validar(PlataformaDTO plataformaDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<PlataformaDTO>> violations = validator.validate(plataformaDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
}
