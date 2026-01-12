package com.lcmuniz.rest_with_spring_boot.services;

import com.lcmuniz.rest_with_spring_boot.exception.ResourceNotFoundException;
import com.lcmuniz.rest_with_spring_boot.model.Person;
import com.lcmuniz.rest_with_spring_boot.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        logger.info("Finding person by ID: " + id);
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }

    public Collection<Person> findAll() {
        logger.info("Finding all people");
        return personRepository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return personRepository.save(person);
    }

    public Person update(Long id, Person person) {
        logger.info("Updating one person");
        Person dbPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        if (person.getFirstName() != null && !person.getFirstName().isBlank()) dbPerson.setFirstName(person.getFirstName());
        if (person.getLastName() != null && !person.getLastName().isBlank()) dbPerson.setLastName(person.getLastName());
        if (person.getEmail() != null && !person.getEmail().isBlank()) dbPerson.setEmail(person.getEmail());
        if (person.getGender() != null && !person.getGender().isBlank()) dbPerson.setGender(person.getGender());
        return personRepository.save(dbPerson);
    }

    public void delete(Long id) {
        logger.info("Deleting person with ID: " + id);
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        personRepository.deleteById(id);
    }

}
