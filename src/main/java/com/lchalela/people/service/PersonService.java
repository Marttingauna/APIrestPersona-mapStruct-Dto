package com.lchalela.people.service;

import com.lchalela.people.dto.PersonDto;
import com.lchalela.people.model.Person;

import java.util.List;

public interface PersonService {

    //Metodo para obtener una persona por su id.(En este caso retorna un objeto de tipo PersonDto)
    PersonDto getPersonById(Long id);
    List<Person> getAllPerson();
    
    // Metodo para guardar una persona.( Recibe por argumento un objeto de tipo PersonDto)
    void savePerson(PersonDto personDto);

    // Metodo para actualizar una persona.( Recibe por argumento un objeto de tipo PersonDto)
    void updatePerson(Long id, PersonDto personDto);

    // Metodo para eliminar una persona por su id.
    void deletePersonById(Long id);
}