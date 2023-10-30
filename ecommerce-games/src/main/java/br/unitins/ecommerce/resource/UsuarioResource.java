package br.unitins.ecommerce.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.ecommerce.dto.usuario.UsuarioDTO;
import br.unitins.ecommerce.dto.usuario.UsuarioResponseDTO;
import br.unitins.ecommerce.service.usuario.UsuarioService;
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

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    UsuarioService usuarioService;

    private static final Logger LOG = Logger.getLogger(UsuarioResource.class);

    @GET
    public List<UsuarioResponseDTO> getAllUsuario() {

        LOG.info("Buscando todos os usuários");
        LOG.debug("ERRO DE DEBUG.");

        return usuarioService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<UsuarioResponseDTO> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todos os usuarios");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return usuarioService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public UsuarioResponseDTO getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando usuário por nome");
        LOG.debug("ERRO DE DEBUG.");

        return usuarioService.getById(id);
    }

    @POST
    public Response insert(UsuarioDTO usuarioDto) {

        LOG.infof("Usuário criado com sucesso.");

        return Response
                .status(Status.CREATED) // 201
                .entity(usuarioService.insert(usuarioDto))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, UsuarioDTO usuarioDto) {
    
        usuarioService.update(id, usuarioDto);
        LOG.infof("Usuário (%d) atualizado com sucesso.", id);

        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {
        try {
            usuarioService.delete(id);
            LOG.infof("Produto excluído com sucesso.", id);

            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar usuário: parâmetros inválidos.", e);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<UsuarioResponseDTO> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return usuarioService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return usuarioService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return usuarioService.countByNome(nome);
    }
}
