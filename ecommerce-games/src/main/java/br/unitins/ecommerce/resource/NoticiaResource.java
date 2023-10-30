package br.unitins.ecommerce.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.ecommerce.dto.noticia.NoticiaDTO;
import br.unitins.ecommerce.dto.noticia.NoticiaResponseDTO;
import br.unitins.ecommerce.service.noticia.NoticiaService;
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

@Path("/noticias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoticiaResource {
    
    @Inject
    NoticiaService noticiaService;

    private static final Logger LOG = Logger.getLogger(NoticiaResource.class);

    @GET
    public List<NoticiaResponseDTO> getAll() {
        LOG.info("Buscando todos as Noticias.");
        LOG.debug("ERRO DE DEBUG.");

        return noticiaService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<NoticiaResponseDTO> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as noticias");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return noticiaService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public NoticiaResponseDTO getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando Noticia por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return noticiaService.getById(id);
    }

    @POST
    public Response insert(NoticiaDTO noticiaDTO) {

        LOG.infof("Inserindo uma Noticia: %s", noticiaDTO.titulo());

        return Response.status(Status.CREATED).entity(noticiaService.insert(noticiaDTO)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, NoticiaDTO noticiaDTO) {
        
        noticiaService.update(id, noticiaDTO);
        LOG.infof("Noticia (%d) atualizada com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            noticiaService.delete(id);
            LOG.infof("Noticia (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar Noticia: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("Noticia (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{titulo}")
    public List<NoticiaResponseDTO> search(
            @PathParam("titulo") String titulo,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return noticiaService.getByTitulo(titulo, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return noticiaService.count();
    }

    @GET
    @Path("/search/{titulo}/count")
    public long count(@PathParam("titulo") String titulo){

        return noticiaService.countByTitulo(titulo);
    }
}
