package br.unitins.ecommerce.form;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import br.unitins.ecommerce.resource.GameResource;
import jakarta.ws.rs.FormParam;

public class GameImageForm {

    private static final Logger LOG = Logger.getLogger(GameImageForm.class);

    @FormParam("id")
    private long id;

    @FormParam("nomeImagem")
    private String nomeImagem;

    @FormParam("imagem")
    @PartType("application/octet-stream")
    private byte[] imagem;

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        LOG.info("chegaste?");
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}