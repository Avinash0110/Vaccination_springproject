package com.avinash.covidproject.vaccination11.dto;

import com.avinash.covidproject.vaccination11.entity.Role;
import lombok.Data;
import lombok.ToString;


import javax.validation.constraints.*;
import java.util.Collection;


@Data
public class UserDto
{
    @NotNull
    private int id;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String userName;



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

    private String vaccinationStatus;

    @ToString.Exclude
    private Collection<Role> roles;

    public UserDto(int id, String userName, String firstName, String lastName, String email, String gender, int age, String adharCard, String vaccinationStatus) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.adharCard = adharCard;
        this.vaccinationStatus = vaccinationStatus;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", adharCard='" + adharCard + '\'' +
                ", vaccinationStatus='" + vaccinationStatus + '\'' +
                '}';
    }
}
