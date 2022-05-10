package com.lchalela.people.controller;

import com.lchalela.people.dto.PersonDto;
import com.lchalela.people.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController{

    @Autowired
    private PersonService personService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> findAllPerson(){
        response.clear();
        response.put("people",personService.getAllPerson());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getPersonById(@PathVariable Long id){
        response.clear();
        response.put("person",personService.getPersonById(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/new")
    /* Metodo controlador recibe por RequestBody un objeto de tipo personDto
        * y lo guarda en la base de datos llamando al servicio pertinente.
    */
    private ResponseEntity<?> savePerson(@Valid @RequestBody PersonDto personDto){
        response.clear();
        personService.savePerson(personDto);
        response.put("message","Persona guardada correctamente");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    /* Mismo caso, Metodo controlador recibe por RequestBody un objeto de tipo personDto
        * y lo guarda en la base de datos llamando al servicio pertinente.
    */
    private ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody PersonDto personDto){
        response.clear();
        personService.updatePerson(id,personDto);
        response.put("message","Persona actualizada correctamente");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePersonById(@PathVariable Long id){
        response.clear();
        personService.deletePersonById(id);
        response.put("message","Persona eliminada correctamente");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}