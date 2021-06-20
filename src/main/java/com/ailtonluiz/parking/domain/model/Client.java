package com.ailtonluiz.parking.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String dni;

    @JsonIgnore
    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Vehicle vehicle;


}
