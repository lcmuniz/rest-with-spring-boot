package com.lcmuniz.rest_with_spring_boot.controllers.v1;

import com.lcmuniz.rest_with_spring_boot.dto.v1.PersonDTOV1;
import com.lcmuniz.rest_with_spring_boot.services.v1.PersonV1Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping({"/people", "/people/v1"})
public class PersonV1Controller {

    private final PersonV1Service personV1Service;

    public PersonV1Controller(PersonV1Service personV1Service) {
        this.personV1Service = personV1Service;
    }

    @GetMapping("/{id}")
    public PersonDTOV1 findById(@PathVariable Long id) {
        return personV1Service.findById(id);
    }

    @GetMapping
    public Collection<PersonDTOV1> findById() {
        return personV1Service.findAll();
    }

    @PostMapping
    public PersonDTOV1 create(@RequestBody PersonDTOV1 person) {
        return personV1Service.create(person);
    }

    @PutMapping("/{id}")
    public PersonDTOV1 update(@PathVariable Long id, @RequestBody PersonDTOV1 person) {
        return personV1Service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personV1Service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
