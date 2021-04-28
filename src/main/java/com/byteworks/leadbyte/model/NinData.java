package com.byteworks.leadbyte.model;

import com.byteworks.leadbyte.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "nindata", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nin"
        })
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NinData extends DateAudit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 11, min = 11)
    @Column(name = "nin")
    private String nin;

    @NotBlank
    @Size(max = 40)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 40)
    @Column(name = "surname")
    private String surname;

    @NotBlank
    @Size(max = 40)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 40)
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Size(max = 11)
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "head_shot", length = 10000)
    private String headShot;

    public NinData() {
    }

    public NinData(@NotBlank @Size(max = 11, min = 11) String nin, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 40) String surname, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 40) String dateOfBirth, @Size(max = 11) String phoneNumber, String headShot) {
        this.nin = nin;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.headShot = headShot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeadShot() {
        return headShot;
    }

    public void setHeadShot(String headShot) {
        this.headShot = headShot;
    }

    @Override
    public String toString() {
        return "NinData{" +
                "id=" + id +
                ", nin='" + nin + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", headShot='" + headShot + '\'' +
                '}';
    }
}
