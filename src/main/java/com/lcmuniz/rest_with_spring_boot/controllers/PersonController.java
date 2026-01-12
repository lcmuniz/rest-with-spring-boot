package com.lcmuniz.rest_with_spring_boot.controllers;

import com.lcmuniz.rest_with_spring_boot.model.Person;
import com.lcmuniz.rest_with_spring_boot.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public Collection<Person> findById() {
        return personService.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
