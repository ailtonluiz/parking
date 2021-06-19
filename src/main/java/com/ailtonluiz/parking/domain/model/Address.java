package com.ailtonluiz.parking.domain.model;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Address {

    private String street;

    private String number;

    private String complement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_city_id")
    private City city;

}
