package br.unitins.ecommerce.resource;

import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.ecommerce.application.Result;
import br.unitins.ecommerce.dto.game.GameDTO;
import br.unitins.ecommerce.dto.game.GameResponseDTO;
import br.unitins.ecommerce.form.GameImageForm;
import br.unitins.ecommerce.service.file.FileService;
import br.unitins.ecommerce.service.game.GameService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    
    @Inject
    GameService gameService;

    @Inject
    FileService fileService;
    
    private static final Logger LOG = Logger.getLogger(GameResource.class);

    @GET
    public List<GameResponseDTO> getAll() {
        LOG.info("Buscando todos as Games.");
        LOG.debug("ERRO DE DEBUG.");
        return gameService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<GameResponseDTO> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todos os games");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return gameService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @RolesAllowed("Admin")
    @Path("/{id}")
    public GameResponseDTO getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando Game por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return gameService.getById(id);
    }

    @POST
    @RolesAllowed("Admin")
    public Response insert(GameDTO gameDTO) {
        LOG.infof("Inserindo uma Game: %s", gameDTO.nome());

        GameResponseDTO game = gameService.insert(gameDTO);

        LOG.infof("Game (%d) criado com sucesso.", game.id());

        return Response.status(Status.CREATED).entity(game).build();
    }

    @PUT
    @RolesAllowed("Admin")
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, GameDTO gameDTO) {
        
        GameResponseDTO game = gameService.update(id, gameDTO);
        LOG.infof("Game (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.CREATED)
                .entity(game) // 204
                .build();
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            gameService.delete(id);
            LOG.infof("Game (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar Game: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("Game (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {

        LOG.info("pego a imagem");

        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename="+nomeImagem);
        return response.build();
    }

    @PATCH
    // @RolesAllowed("Admin")
    @Path("/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm GameImageForm form) {

        try {
            fileService.salvar(form.getId(), form.getNomeImagem(), form.getImagem());
            return Response.noContent().build();
        } catch (IOException e) {
            Result result = new Result(e.getMessage());
            return Response.status(Status.CONFLICT).entity(result).build();
        }

    }

    @GET
    // @RolesAllowed("Admin")
    @Path("/search/{nome}")
    public List<GameResponseDTO> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return gameService.getByNome(nome, page, pageSize);
    }

    @GET
    // @RolesAllowed("Admin")
    @Path("/count")
    public long count(){

        return gameService.count();
    }

    @GET
    // @RolesAllowed("Admin")
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return gameService.countByNome(nome);
    }

    @GET
    // @RolesAllowed("Admin")
    @Produces("application/pdf")
    @Path("/relatorio")
    public Response gerarRelatorio(){
        LOG.info("Baixando relatório de games");
        LOG.debug("ERRO DE DEBUG.");

        byte[] pdf = gameService.criarRelatorioGames("");
        return Response.ok(pdf).header("Content-Disposition", "filename=attachment;relatorioGames.pdf").build();
    }
}
