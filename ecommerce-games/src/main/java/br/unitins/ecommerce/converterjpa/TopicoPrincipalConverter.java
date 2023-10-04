package br.unitins.ecommerce.converterjpa;

import br.unitins.ecommerce.model.noticia.TopicoPrincipal;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TopicoPrincipalConverter implements AttributeConverter<TopicoPrincipal, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TopicoPrincipal topicoPrincipal) {
        
        return topicoPrincipal == null ? null : topicoPrincipal.getId();
    }

    @Override
    public TopicoPrincipal convertToEntityAttribute(Integer id) {
        
        return id == null ? null : TopicoPrincipal.valueOf(id);
    }
    
}
