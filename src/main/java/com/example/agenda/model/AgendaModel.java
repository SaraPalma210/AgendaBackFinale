package com.example.agenda.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "agenda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgendaModel {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String street;
    private Integer postalCode;
    private String city;
    private LocalDate birthday;
}
