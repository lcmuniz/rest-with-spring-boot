package com.lcmuniz.rest_with_spring_boot.mocks;

import com.lcmuniz.rest_with_spring_boot.dto.v1.PersonDTOV1;
import com.lcmuniz.rest_with_spring_boot.model.v1.Person;

import java.util.ArrayList;
import java.util.Collection;

public class MockPerson {

    public Person mockPersonEntity() {
        return mockEntity(0L);
    }

    public PersonDTOV1 mockPersonDTO() {
        return mockDTO(0L);
    }

    public Collection<Person> mockPersonEntityCollection() {
        Collection<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            people.add(mockEntity((long) i+1));
        }
        return people;
    }

    public Collection<PersonDTOV1> mockPersonDTOCollection() {
        Collection<PersonDTOV1> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            people.add(mockDTO((long) i+1));
        }
        return people;
    }

    public Person mockEntity(Long id) {
        Person person = new Person();
        person.setId(id);
        person.setFirstName("First Name "  + id);
        person.setLastName("Last Name " + id);
        person.setEmail("email" + id + "@gmail.com");
        person.setGender(id % 2 == 0 ? "MALE" : "FEMALE");
        return person;
    }

    private PersonDTOV1 mockDTO(Long id) {
        PersonDTOV1 person = new PersonDTOV1();
        person.setId(id);
        person.setFirstName("First Name "  + id);
        person.setLastName("Last Name " + id);
        person.setEmail("email" + id + "@gmail.com");
        person.setGender(id % 2 == 0 ? "MALE" : "FEMALE");
        return person;
    }

}
