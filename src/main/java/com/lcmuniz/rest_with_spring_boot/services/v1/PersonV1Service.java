package com.lcmuniz.rest_with_spring_boot.services.v1;

import com.lcmuniz.rest_with_spring_boot.dto.v1.PersonDTOV1;
import com.lcmuniz.rest_with_spring_boot.exception.ResourceNotFoundException;
import com.lcmuniz.rest_with_spring_boot.mapper.ObjectMapper;
import com.lcmuniz.rest_with_spring_boot.model.v1.Person;
import com.lcmuniz.rest_with_spring_boot.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonV1Service {

    private final PersonRepository personRepository;
    private final Logger logger = LoggerFactory.getLogger(PersonV1Service.class.getName());

    public PersonV1Service(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTOV1 findById(Long id) {
        logger.info("Finding person by ID: " + id);
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        return ObjectMapper.map(person, PersonDTOV1.class);
    }

    public Collection<PersonDTOV1> findAll() {
        logger.info("Finding all people");
        return ObjectMapper.mapList(personRepository.findAll(), PersonDTOV1.class);
    }

    public PersonDTOV1 create(PersonDTOV1 person) {
        logger.info("Creating one person");
        Person personEntity = ObjectMapper.map(person, Person.class);
        Person savedPerson = personRepository.save(personEntity);
        return ObjectMapper.map(savedPerson, PersonDTOV1.class);
    }

    public PersonDTOV1 update(Long id, PersonDTOV1 person) {
        logger.info("Updating one person");
        Person dbPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        if (person.getFirstName() != null && !person.getFirstName().isBlank()) dbPerson.setFirstName(person.getFirstName());
        if (person.getLastName() != null && !person.getLastName().isBlank()) dbPerson.setLastName(person.getLastName());
        if (person.getEmail() != null && !person.getEmail().isBlank()) dbPerson.setEmail(person.getEmail());
        if (person.getGender() != null && !person.getGender().isBlank()) dbPerson.setGender(person.getGender());
        Person savedPerson = personRepository.save(dbPerson);
        return ObjectMapper.map(savedPerson, PersonDTOV1.class);
    }

    public void delete(Long id) {
        logger.info("Deleting person with ID: " + id);
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        personRepository.deleteById(id);
    }

}
