package br.unitins.ecommerce.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.ecommerce.dto.developer.DeveloperDTO;
import br.unitins.ecommerce.dto.developer.DeveloperResponseDTO;
import br.unitins.ecommerce.service.developer.DeveloperService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/developers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeveloperResource {
    
    @Inject
    DeveloperService developerService;

    private static final Logger LOG = Logger.getLogger(DeveloperResource.class);

    @GET
    public List<DeveloperResponseDTO> getAll() {
        LOG.infof("Buscando todos os developers");
        LOG.debug("ERRO DE DEBUG.");
        return developerService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<DeveloperResponseDTO> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todos os developers");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return developerService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public DeveloperResponseDTO getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.infof("Buscando developers por ID. ", id);
        LOG.debug("ERRO DE DEBUG.");
        return developerService.getById(id);
    }

    @POST
    public Response insert(DeveloperDTO developerDTO) {

        LOG.infof("Inserindo um developer: %s", developerDTO.nome());

        return Response
                .status(Status.CREATED) // 201
                .entity(developerService.insert(developerDTO))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DeveloperDTO developerDTO) {
        
        developerService.update(id, developerDTO);
        LOG.infof("Developer (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {
        try {
            developerService.delete(id);
            LOG.infof("developer excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar um developer: parâmetros inválidos.", e);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<DeveloperResponseDTO> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return developerService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return developerService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return developerService.countByNome(nome);
    }
}
