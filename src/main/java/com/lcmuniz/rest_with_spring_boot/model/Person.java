package com.lcmuniz.rest_with_spring_boot.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(schema = "rest-with-spring-boot", name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 6, nullable = false)
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, email, gender);
    }

}
