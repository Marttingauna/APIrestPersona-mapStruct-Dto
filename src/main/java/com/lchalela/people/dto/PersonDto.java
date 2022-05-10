package com.lchalela.people.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    // Atributos de la clase PersonDto.
    // Es decir solo los atributos que no sean privados o que no comprometa la seguridad por ejemplo.
    @NotEmpty(message = "El nombre es requerido!")
    private String name;
    @NotEmpty(message = "Lastname is required!")
    private String lastName;
}