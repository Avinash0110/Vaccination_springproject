package com.avinash.covidproject.vaccination11.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "adhar_card")
    private String adharCard;

    @Column(name = "vaccination_status")
    private String vaccinationStatus;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    @ToString.Exclude
    private Collection<Role> roles;


    public User(String userName, String password, String firstName, String lastName, String email, String gender, int age, String adharCard, String vaccinationStatus) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.adharCard = adharCard;
        this.vaccinationStatus = vaccinationStatus;
    }


    public User(String userName, String password, String firstName, String lastName, String email, String gender, int age, String adharCard, String vaccinationStatus, Collection<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.adharCard = adharCard;
        this.vaccinationStatus = vaccinationStatus;
        this.roles = roles;
    }

    public User(int id, String userName, String password, String firstName, String lastName, String email, String gender, int age, String adharCard, String vaccinationStatus) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.adharCard = adharCard;
        this.vaccinationStatus = vaccinationStatus;
    }

    public User(int id, String userName, String firstName, String lastName, String email, String gender, int age, String adharCard, String vaccinationStatus) {
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


}