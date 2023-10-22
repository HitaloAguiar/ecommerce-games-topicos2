package br.unitins.ecommerce.repository;

import br.unitins.ecommerce.model.noticia.Noticia;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NoticiaRepository implements PanacheRepository<Noticia> {
    
    public PanacheQuery<Noticia> findByNome(String titulo, Sort sort){

        if (titulo == null)
            return null;

        return find("UPPER(titulo) LIKE ?1 ", sort, "%"+titulo.toUpperCase()+"%");
    }
}
