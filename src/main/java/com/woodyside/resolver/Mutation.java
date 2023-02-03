package com.woodyside.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.woodyside.model.Address;
import com.woodyside.model.City;
import com.woodyside.model.House;
import com.woodyside.model.HouseType;
import com.woodyside.repository.AddressRepository;
import com.woodyside.repository.CityRepository;
import com.woodyside.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final HouseRepository houseRepository;

    public City createCity(String name, Long population) {

        City city = City.builder()
                .name(name)
                .population(population)
                .build();

        cityRepository.save(city);

        return city;
    }

    @Transactional
    public House createHouse(HouseType houseType, Integer cityId) {

        City found = cityRepository.findById(cityId)
                .orElseThrow(NoSuchElementException::new);

        House house = House.builder()
                .houseType(houseType)
                .city(found)
                .build();

        houseRepository.save(house);

        return house;
    }

    @Transactional
    public Address createAddress(String street, Integer houseNumber, Long zipcode, Integer houseId, Integer cityId) {

        House foundHouse = houseRepository.findById(houseId)
                .orElseThrow(NoSuchElementException::new);

        City foundCity = cityRepository.findById(cityId)
                .orElseThrow(NoSuchElementException::new);

        String cityName = foundCity.getName();

        Address address = Address.builder()
                .street(street)
                .houseNumber(houseNumber)
                .cityName(cityName)
                .house(foundHouse)
                .zipcode(zipcode)
                .build();

        addressRepository.save(address);

        return address;
    }

    public boolean deleteCity(Integer cityId) {
        cityRepository.deleteById(cityId);
        return true;
    }
}
