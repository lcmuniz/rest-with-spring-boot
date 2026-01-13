package com.lcmuniz.rest_with_spring_boot.dto.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lcmuniz.rest_with_spring_boot.serializers.GenderSerialize;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.Objects;

@JsonFilter("NoSensitiveData")
public class PersonDTOV2 extends RepresentationModel<PersonDTOV2> {

    private Long id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date birthDate;
    private String email;
    private String password;

    @JsonSerialize(using = GenderSerialize.class)
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTOV2 that = (PersonDTOV2) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, email, password, gender);
    }
}
