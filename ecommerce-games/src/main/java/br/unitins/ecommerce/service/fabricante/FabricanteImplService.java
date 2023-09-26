package br.unitins.ecommerce.service.fabricante;

import java.util.List;
import java.util.Set;

import br.unitins.ecommerce.dto.FabricanteDTO;
import br.unitins.ecommerce.model.produto.Fabricante;
import br.unitins.ecommerce.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FabricanteImplService implements FabricanteService {

    @Inject
    Validator validator;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> getAll() {
        
        return fabricanteRepository.findAll().list();
    }

    @Override
    public Fabricante getById(Long id) {
        
        Fabricante fabricante = fabricanteRepository.findById(id);

        if (fabricante == null)
            throw new NotFoundException("Não encontrado");

        return fabricante;
    }

    @Override
    @Transactional
    public Fabricante insert(FabricanteDTO fabricanteDTO) {
        
        validar(fabricanteDTO);

        Fabricante fabricante = new Fabricante();

        fabricante.setNome(fabricanteDTO.nome());

        fabricante.setAnoFundacao(fabricanteDTO.anoFundacao());

        fabricanteRepository.persist(fabricante);

        return fabricante;
    }

    @Override
    @Transactional
    public Fabricante update(Long id, FabricanteDTO fabricanteDTO) {
        
        validar(fabricanteDTO);

        Fabricante fabricante = fabricanteRepository.findById(id);

        if (fabricante == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        fabricante.setNome(fabricanteDTO.nome());

        fabricante.setAnoFundacao(fabricanteDTO.anoFundacao());

        return fabricante;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Fabricante fabricante = fabricanteRepository.findById(id);

        if (fabricanteRepository.isPersistent(fabricante))
            fabricanteRepository.delete(fabricante);

        else
            throw new NotFoundException("Nenhum fabricante encontrado");
    }
    
    private void validar(FabricanteDTO fabricanteDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<FabricanteDTO>> violations = validator.validate(fabricanteDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }
}
