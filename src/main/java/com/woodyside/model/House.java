package com.woodyside.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "House")
@Table(name = "HOUSE")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_seq")
    @SequenceGenerator(name = "house_seq", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "HOUSE_TYPE")
    @Enumerated(value = EnumType.STRING)
    private HouseType houseType;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
    @JoinColumn(name = "fk_city")
    private City city;

    @OneToOne(mappedBy = "house",cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, targetEntity = Address.class)
    private Address address;
}
