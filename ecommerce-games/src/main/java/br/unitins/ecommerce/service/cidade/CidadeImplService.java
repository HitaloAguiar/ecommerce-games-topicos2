package br.unitins.ecommerce.service.cidade;

import java.util.List;
import java.util.Set;

import br.unitins.ecommerce.dto.CidadeDTO;
import br.unitins.ecommerce.model.endereco.Cidade;
import br.unitins.ecommerce.repository.CidadeRepository;
import br.unitins.ecommerce.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CidadeImplService implements CidadeService {

    @Inject
    Validator validator;

    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    EstadoRepository estadoRepository;

    @Override
    public List<Cidade> getAll() {
        
        return cidadeRepository.findAll().list();
    }

    @Override
    public Cidade getById(Long id) {
        
        Cidade cidade = cidadeRepository.findById(id);

        if (cidade == null)
            throw new NotFoundException("Não encontrado");

        return cidade;
    }

    @Override
    @Transactional
    public Cidade insert(CidadeDTO cidadeDTO) {
        
        validar(cidadeDTO);

        Cidade cidade = new Cidade();

        cidade.setNome(cidadeDTO.nome());

        cidade.setEstado(estadoRepository.findById(cidadeDTO.estado()));

        cidadeRepository.persist(cidade);

        return cidade;
    }

    @Override
    @Transactional
    public Cidade update(Long id, CidadeDTO cidadeDTO) {
        
        validar(cidadeDTO);

        Cidade cidade = cidadeRepository.findById(id);

        if (cidade == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        cidade.setNome(cidadeDTO.nome());

        cidade.setEstado(estadoRepository.findById(cidadeDTO.estado()));

        return cidade;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Cidade cidade = cidadeRepository.findById(id);

        if (cidadeRepository.isPersistent(cidade))
            cidadeRepository.delete(cidade);

        else
            throw new NotFoundException("Nenhuma cidade encontrado");
    }
    
    private void validar(CidadeDTO cidadeDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<CidadeDTO>> violations = validator.validate(cidadeDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }
}
