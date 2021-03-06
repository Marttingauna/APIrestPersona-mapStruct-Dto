package com.lchalela.people.service.impl;

import com.lchalela.people.dto.PersonDto;
import com.lchalela.people.exception.NotFoundException;
import com.lchalela.people.mapper.PersonMapper;
import com.lchalela.people.model.Person;
import com.lchalela.people.repository.PersonRepository;
import com.lchalela.people.service.PersonService;
import com.lchalela.people.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private PersonMapper personMapper;

    @Override
    // Metodo para obtener una persona por su id.(En este caso retorna un objeto de tipo PersonDto)
    public PersonDto getPersonById(Long id) {
        return personMapper.toDto(personRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(messageUtil.getMessage("notFound",null, Locale.getDefault()))
        ));
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }


    @Transactional // Para que se ejecute en una transaccion de base de datos. es decir que se guarde en la base de datos y no se ejecute en dos pasos.
    @Override
    public void savePerson(PersonDto personDto) {
        /* Utiliza el mapeo para convertir el objeto de tipo PersonDto a un objeto de tipo Person. 
            *Este método 'toEntity', declarado en la interfaz PersonMapper, 
            es el que se encarga de la conversion, y el método toDto, es el que se encarga de la conversion inversa
         */
        Person person = personMapper.toEntity(personDto);

        // Guarda el objeto de tipo Person en la base de datos.
        personRepository.save(person);
    }

    @Transactional
    @Override
    public void updatePerson(Long id, PersonDto personDto) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtil.getMessage("notFound",null,Locale.getDefault()))
        );

        // Utiliza el mapeo para convertir el objeto de tipo PersonDto a un objeto de tipo Person.
        personMapper.updateEntity(personDto,person1);
        personRepository.save(person1);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}