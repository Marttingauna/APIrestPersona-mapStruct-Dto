package com.lchalela.people.mapper;

import com.lchalela.people.dto.PersonDto;
import com.lchalela.people.model.Person;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    
    // Metodo que retorna un objeto de tipo Persona, es decir convertir de un DTO a una persona.
    Person toEntity(PersonDto personDto);

    // Metodo para convertir un objeto de tipo Persona a un DTO.
    PersonDto toDto(Person person);

    // Metodo para actualizar una entidad tipo persona. (Recibe por argumento un objeto de tipo PersonDto y un objeto de tipo Person)
    // @MappingTarget es para indicar que el objeto que se recibe por argumento es el objeto que se va a actualizar.
    //BeanMapping(nullValuePropertyMappingStrategy) es para indicar que si el valor de una propiedad es null, se debe de ignorar.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PersonDto personDto, @MappingTarget Person person);
}