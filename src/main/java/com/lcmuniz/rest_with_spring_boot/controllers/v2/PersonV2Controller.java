package com.lcmuniz.rest_with_spring_boot.controllers.v2;

import com.lcmuniz.rest_with_spring_boot.dto.v2.PersonDTOV2;
import com.lcmuniz.rest_with_spring_boot.services.v2.PersonV2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/people/v2")
public class PersonV2Controller {

    private final PersonV2Service personV2Service;

    public PersonV2Controller(PersonV2Service personV2Service) {
        this.personV2Service = personV2Service;
    }

    @GetMapping("/{id}")
    public PersonDTOV2 findById(@PathVariable Long id) {
        return personV2Service.findById(id);
    }

    @GetMapping
    public Collection<PersonDTOV2> findById() {
        return personV2Service.findAll();
    }

    @PostMapping
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
        return personV2Service.create(person);
    }

    @PutMapping("/{id}")
    public PersonDTOV2 update(@PathVariable Long id, @RequestBody PersonDTOV2 person) {
        return personV2Service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personV2Service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
