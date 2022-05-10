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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PersonDto personDto, @MappingTarget Person person);
}