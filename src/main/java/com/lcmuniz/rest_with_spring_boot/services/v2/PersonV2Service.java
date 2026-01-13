package com.lcmuniz.rest_with_spring_boot.services.v2;

import com.lcmuniz.rest_with_spring_boot.dto.v2.PersonDTOV2;
import com.lcmuniz.rest_with_spring_boot.exception.ResourceNotFoundException;
import com.lcmuniz.rest_with_spring_boot.mapper.ObjectMapper;
import com.lcmuniz.rest_with_spring_boot.model.v1.Person;
import com.lcmuniz.rest_with_spring_boot.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonV2Service {

    private final PersonRepository personRepository;
    private final Logger logger = LoggerFactory.getLogger(PersonV2Service.class.getName());

    public PersonV2Service(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTOV2 findById(Long id) {
        logger.info("Finding person by ID: " + id);
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        return ObjectMapper.map(person, PersonDTOV2.class);
    }

    public Page<PersonDTOV2> findAll(Pageable pageable) {
        logger.info("Finding all people");
        return  personRepository.findAll(pageable).map(p -> ObjectMapper.map(p, PersonDTOV2.class));
    }

    public PersonDTOV2 create(PersonDTOV2 person) {
        logger.info("Creating one person");
        Person personEntity = ObjectMapper.map(person, Person.class);
        Person savedPerson = personRepository.save(personEntity);
        return ObjectMapper.map(savedPerson, PersonDTOV2.class);
    }

    public PersonDTOV2 update(Long id, PersonDTOV2 person) {
        logger.info("Updating one person");
        Person dbPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        if (person.getFirstName() != null && !person.getFirstName().isBlank()) dbPerson.setFirstName(person.getFirstName());
        if (person.getLastName() != null && !person.getLastName().isBlank()) dbPerson.setLastName(person.getLastName());
        if (person.getBirthDate() != null) dbPerson.setBirthDate(person.getBirthDate());
        if (person.getEmail() != null && !person.getEmail().isBlank()) dbPerson.setEmail(person.getEmail());
        if (person.getGender() != null && !person.getGender().isBlank()) dbPerson.setGender(person.getGender());
        Person savedPerson = personRepository.save(dbPerson);
        return ObjectMapper.map(savedPerson, PersonDTOV2.class);
    }

    public void delete(Long id) {
        logger.info("Deleting person with ID: " + id);
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        personRepository.deleteById(id);
    }

}
