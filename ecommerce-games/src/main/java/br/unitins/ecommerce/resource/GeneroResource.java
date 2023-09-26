package br.unitins.ecommerce.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.ecommerce.application.Result;
import br.unitins.ecommerce.dto.GeneroDTO;
import br.unitins.ecommerce.model.produto.Genero;
import br.unitins.ecommerce.service.genero.GeneroService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/generos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GeneroResource {

    @Inject
    GeneroService generoService;

    private static final Logger LOG = Logger.getLogger(GeneroResource.class);

    @GET
    public List<Genero> getAll() {
        LOG.infof("Buscando todos os gêneros");
        LOG.debug("ERRO DE DEBUG.");
        return generoService.getAll();
    }

    @GET
    @Path("/{id}")
    public Genero getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.infof("Buscando gêneros por ID. ", id);
        LOG.debug("ERRO DE DEBUG.");
        return generoService.getById(id);
    }

    @POST
    public Response insert(GeneroDTO generoDTO) {
        LOG.infof("Inserindo um gênero: %s", generoDTO.nome());
        Result result = null;
        try {

            return Response
                    .status(Status.CREATED) // 201
                    .entity(generoService.insert(generoDTO))
                    .build();

        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao incluir um gênero.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());

        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);

        }
        return Response
                .status(Status.NOT_FOUND)
                .entity(result)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, GeneroDTO generoDTO) {
        Result result = null;
        try {
            generoService.update(id, generoDTO);
            LOG.infof("Genero (%d) atualizado com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT) // 204
                    .build();

        } catch (ConstraintViolationException e) {
            LOG.errorf("Erro ao atualizar um Genero. ", id, e);
            LOG.debug(e.getMessage());

            result = new Result(e.getConstraintViolations());

        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);

        }
        return Response
                .status(Status.NOT_FOUND)
                .entity(result)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {
        try {
            generoService.delete(id);
            LOG.infof("gênero excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar um gênero: parâmetros inválidos.", e);
            throw e;
        }
    }
}
