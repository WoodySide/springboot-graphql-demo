package com.woodyside.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Address")
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NUMBER")
    private Integer houseNumber;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "ZIP_CODE")
    @Accessors(fluent = true)
    private Long zipcode;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = House.class)
    @JoinColumn(name = "fk_house")
    @ToString.Exclude
    private House house;
}
