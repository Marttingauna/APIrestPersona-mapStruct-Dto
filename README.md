
## 💡Ejemplo de uso MapStruct/ Dto

-  [x] **PersonDto**

Primero se crea la clase **PersonDto** con los siguientes atributos:

 - **`private  String  name;`**
 - **`private  String  lastName;`**

En esta clase tendrá solo los atributos que no sean privados o que no comprometa la seguridad por ejemplo.

----
 - [x] **Mapper**

Luego el mapper, en este caso llamado PersonMapper.java. Esta interface se declaran los metodos 

 - **`toEntity(PersonDto personDto)`**

 Este retorna un objeto de tipo Persona, es decir convertir de un DTO a una persona.

 - **`toDto(Person  person)`**
 
 Metodo para convertir un objeto de tipo Persona a un DTO.

 - **`updateEntity(PersonDto  personDto, @MappingTarget  Person  person)`**

Metodo para actualizar una entidad tipo persona. (Recibe por argumento un objeto de tipo PersonDto y un objeto de tipo Person).
**@MappingTarget** es para indicar que el objeto que se recibe por argumento es el objeto que se va a actualizar.
Tambien en este caso cuenta con la anotacion **@BeanMapping**, indicada de la siguiente manera:

 - **`@BeanMapping(nullValuePropertyMappingStrategy=NullValuePropertyMappingStrategy.IGNORE)`**

*BeanMapping(nullValuePropertyMappingStrategy)* es para indicar que si el valor de una propiedad es null, se debe de ignorar.

---
- [x] Servicio 

Luego tendremos que actualizar el servicio pertinente en este caso en el ***PersonService.java***. Podemos observar las modificaciones:

 - `void  savePerson(PersonDto personDto)`

Este método para guarda una persona.( Recibe por argumento un objeto de tipo **PersonDto**)

 - `void  updatePerson(Long  id, PersonDto  personDto)`

De la misma manera, con la diferencia de  actualizar una persona.( Recibe por argumento un objeto de tipo **PersonDto**)

----

Luego en la clase ***PersonServiceImpl.java***  

 - **`private PersonMapper  personMapper;`**

Declaramos el atributo de tipo **PerdonaMapper** declarada anteriormente (donde tendremos accedo a los metodos de dicha interface)

Hacemos uso en los siguientes metodos:

**`public  PersonDto  getPersonById(Long  id)`**

Metodo para obtener una persona por su id.(En este caso retorna un objeto de tipo **PersonDto**), dado esto hacenmos uso de ***PersonMapper*** en su funcion ***toDto()*** recibiendo el tipo de persona para convertir a un tipo de **PersonDto**

**`public  void  savePerson(PersonDto  personDto)`**

En el cuerpo del metodo , mismo caso, pero con la diferencia de utilizar el mapeo para convertir el objeto de tipo PersonDto a un objeto de tipo Person.

*Este método '**toEntity**', declarado en la interfaz **PersonMapper**,

es el que se encarga de la conversion, y el método *toDto*, es el que se encarga de la conversion inversa.
Luego el objeto ya mapeado de tipo Person se guarda en la base de datos.

**`
@Transactional`**
**`public  void  updatePerson(Long  id, PersonDto  personDto)`**


Podemos notar el uso de la anotacion **@Transactional**.
Esta se encarga de se ejecute en una transaccion de base de datos. es decir que se guarde en la base de datos y no se ejecute en dos pasos.
En el cuerpo de la funcion podemos notar el uso de la funcion **updateEntity** declarada en el mapper. Es decir hacemos uso del mapeo para actualizar el objeto de tipo **PersonDto** a un objeto de tipo **Person**.

---

## Documentacion para probar las diferentes peticiones HTTP
[![click aqui](https://res.cloudinary.com/postman/image/upload/t_team_logo_pubdoc/v1/team/4dafc4546a067ed3b4522a4b26bd74dbee2fd556bb0d42538c88ac88a7ec14f3)](https://documenter.getpostman.com/view/13757094/UVJeEbTN)
