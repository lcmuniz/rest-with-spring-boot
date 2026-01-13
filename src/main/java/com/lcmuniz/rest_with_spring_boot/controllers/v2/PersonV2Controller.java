package com.lcmuniz.rest_with_spring_boot.controllers.v2;

import com.lcmuniz.rest_with_spring_boot.dto.v2.PersonDTOV2;
import com.lcmuniz.rest_with_spring_boot.services.v2.PersonV2Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/people/v2")
public class PersonV2Controller {

    private final PersonV2Service personV2Service;

    public PersonV2Controller(PersonV2Service personV2Service) {
        this.personV2Service = personV2Service;
    }

    @GetMapping(value = "/{id}")
    public PersonDTOV2 findById(@PathVariable Long id) {
        PersonDTOV2 dto = personV2Service.findById(id);
        return addHateoasLinks(dto);
    }

    @GetMapping
    public ResponseEntity<Page<PersonDTOV2>> findAll(
            @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "100") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "firstName"));
        Page<PersonDTOV2> people = personV2Service.findAll(pageable);
        people.forEach(this::addHateoasLinks);
        return ResponseEntity.ok(people);
    }

    @PostMapping
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
        PersonDTOV2 dto = personV2Service.create(person);
        return addHateoasLinks(dto);
    }

    @PutMapping("/{id}")
    public PersonDTOV2 update(@PathVariable Long id, @RequestBody PersonDTOV2 person) {
        PersonDTOV2 dto = personV2Service.update(id, person);
        return addHateoasLinks(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personV2Service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PersonDTOV2 addHateoasLinks(PersonDTOV2 dto) {
        dto.add(linkTo(methodOn(PersonV2Controller.class).findById(dto.getId())).withSelfRel().withType(HttpMethod.GET.name()));
        dto.add(linkTo(methodOn(PersonV2Controller.class).findAll(0,0)).withRel("find-all").withType(HttpMethod.GET.name()));
        dto.add(linkTo(methodOn(PersonV2Controller.class).delete(dto.getId())).withRel("delete").withType(HttpMethod.DELETE.name()));
        dto.add(linkTo(methodOn(PersonV2Controller.class).create(dto)).withRel("create").withType(HttpMethod.POST.name()));
        dto.add(linkTo(methodOn(PersonV2Controller.class).create(dto)).withRel("update").withType(HttpMethod.PUT.name()));
        return dto;
    }


}
