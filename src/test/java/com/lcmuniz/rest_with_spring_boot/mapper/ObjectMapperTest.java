package com.lcmuniz.rest_with_spring_boot.mapper;

import com.lcmuniz.rest_with_spring_boot.dto.v1.PersonDTOV1;
import com.lcmuniz.rest_with_spring_boot.mocks.MockPerson;
import com.lcmuniz.rest_with_spring_boot.model.v1.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectMapperTest {

    private MockPerson mockPerson;

    @BeforeEach
    void setUp() {
        mockPerson = new MockPerson();
    }

    @Test
    void mapEntityToDTO() {
        PersonDTOV1 dto = ObjectMapper.map(mockPerson.mockPersonEntity(), PersonDTOV1.class);
        assertEquals(0L, dto.getId());
        assertEquals("First Name 0", dto.getFirstName());
        assertEquals("Last Name 0", dto.getLastName());
        assertEquals("email0@gmail.com", dto.getEmail());
        assertEquals("MALE", dto.getGender());

    }

    @Test
    void mapDTOToEntity() {
        Person entity = ObjectMapper.map(mockPerson.mockPersonDTO(), Person.class);
        assertEquals(0L, entity.getId());
        assertEquals("First Name 0", entity.getFirstName());
        assertEquals("Last Name 0", entity.getLastName());
        assertEquals("email0@gmail.com", entity.getEmail());
        assertEquals("MALE", entity.getGender());

    }

    @Test
    void mapDTOCollectionToEntityCollection() {
        Collection<Person> list = ObjectMapper.mapList(mockPerson.mockPersonDTOCollection(), Person.class);
        assertEquals(10, list.size());
        Person entity = list.stream().filter(o -> o.getId().equals(10L)).findFirst().orElseThrow();
        assertEquals(10L, entity.getId());
        assertEquals("First Name 10", entity.getFirstName());
        assertEquals("Last Name 10", entity.getLastName());
        assertEquals("email10@gmail.com", entity.getEmail());
        assertEquals("MALE", entity.getGender());
    }

    @Test
    void mapEntityCollectionToDTOCollection() {
        Collection<PersonDTOV1> list = ObjectMapper.mapList(mockPerson.mockPersonEntityCollection(), PersonDTOV1.class);
        assertEquals(10, list.size());
        PersonDTOV1 dto = list.stream().filter(o -> o.getId().equals(1L)).findFirst().orElseThrow();
        assertEquals(1L, dto.getId());
        assertEquals("First Name 1", dto.getFirstName());
        assertEquals("Last Name 1", dto.getLastName());
        assertEquals("email1@gmail.com", dto.getEmail());
        assertEquals("FEMALE", dto.getGender());
    }

}