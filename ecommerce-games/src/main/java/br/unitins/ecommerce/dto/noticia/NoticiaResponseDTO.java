package br.unitins.ecommerce.dto.noticia;

import java.time.format.DateTimeFormatter;

import br.unitins.ecommerce.model.noticia.Noticia;

public record NoticiaResponseDTO(
    Long id,
    String titulo,
    String dataPublicacao,
    String autor,
    String topicoPrincipal
) {
   
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public NoticiaResponseDTO (Noticia noticia, DateTimeFormatter formatter) {

        this(noticia.getId(), noticia.getTitulo(), noticia.getDataPublicacao().format(formatter), noticia.getAutor(), noticia.getTopicoPrincipal().getLabel());
    }

    public NoticiaResponseDTO (Noticia noticia) {

        this(noticia.getId(), noticia.getTitulo(), noticia.getDataPublicacao().format(formatter), noticia.getAutor(), noticia.getTopicoPrincipal().getLabel());
    }
}
