package br.unitins.ecommerce.resource;

import br.unitins.ecommerce.dto.usuario.AuthUsuarioDTO;
import br.unitins.ecommerce.dto.usuario.UsuarioResponseDTO;
import br.unitins.ecommerce.service.HashService;
import br.unitins.ecommerce.service.JwtService;
import br.unitins.ecommerce.service.usuario.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    HashService hashService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JwtService jwtService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(AuthUsuarioDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.senha());

        UsuarioResponseDTO usuario = usuarioService.findByLoginAndSenha(authDTO.login(), hash);

        if (usuario == null) {
            return Response.status(Status.NOT_FOUND)
                .entity("Usuario não encontrado").build();
        } 
        return Response.ok()
            .header("Authorization", jwtService.generateJwt(usuario))
            .build();

    }

}
