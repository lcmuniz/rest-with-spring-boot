package com.lcmuniz.rest_with_spring_boot.services.v2;

import com.lcmuniz.rest_with_spring_boot.dto.v2.PersonDTOV2;
import com.lcmuniz.rest_with_spring_boot.exception.ResourceNotFoundException;
import com.lcmuniz.rest_with_spring_boot.mocks.MockPerson;
import com.lcmuniz.rest_with_spring_boot.model.v1.Person;
import com.lcmuniz.rest_with_spring_boot.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.rmi.server.ExportException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonV2ServiceTest {

    MockPerson input;

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    private PersonV2Service personV2Service;


    @BeforeEach
    void setUp() {
        input = new MockPerson();
    }

    @Test
    void findById() {
        Person person = input.mockPersonEntity();
        when(personRepository.findById(0L)).thenReturn(Optional.of(person));

        PersonDTOV2 result = personV2Service.findById(0L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(0L, result.getId());
        assertEquals("First Name 0", result.getFirstName());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void updateNullPerson() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> personV2Service.update(0L, null));
        Assertions.assertEquals("Person not found!", exception.getMessage());
    }

}