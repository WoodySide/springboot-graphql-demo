package com.woodyside.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

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
    @ToString.Exclude
    private City city;

    @OneToOne(mappedBy = "house",cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, targetEntity = Address.class)
    @ToString.Exclude
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        House house = (House) o;
        return id != null && Objects.equals(id, house.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
