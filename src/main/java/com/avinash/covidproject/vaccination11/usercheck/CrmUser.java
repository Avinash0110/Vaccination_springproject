package com.avinash.covidproject.vaccination11.usercheck;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CrmUser {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String userName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;


    @NotNull(message = "is required")
    @Size(min = 1,  message = "is required")
    private String email;


    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String gender;

    @NotNull(message = "is required")
    @Min(value=18, message="must be greater than or equal to 18")
    @Max(value=100, message=" must be less than or equal to 100")
    private int age;


    @NotNull(message = "is required")
    @Pattern(regexp = "^[1-9][0-9]{11}",message = "should contain exact 12 digits and should not start with zero")
    private String adharCard;

    private String vaccinationStatus="Not vaccinated";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdharCard() {
        return adharCard;
    }

    public void setAdharCard(String adharCard) {
        this.adharCard = adharCard;
    }

    public String getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(String vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }
}