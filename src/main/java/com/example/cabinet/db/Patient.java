package com.example.cabinet.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fatherName;
    private String motherName;
    private String babyName;
    private Integer phone;
    private String adresse;
    private LocalDate birthday;
    private String birthdayPlace;
    private String email;
    @Lob
    private String signature;

}
