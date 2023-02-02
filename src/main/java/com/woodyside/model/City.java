package com.woodyside.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "City")
@Table(name = "CITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "POPULATION")
    private Long population;

    @OneToMany(mappedBy = "city", targetEntity = House.class, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<House> houses;
}
