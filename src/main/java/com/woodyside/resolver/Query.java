package com.woodyside.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.woodyside.model.Address;
import com.woodyside.model.City;
import com.woodyside.model.House;
import com.woodyside.repository.AddressRepository;
import com.woodyside.repository.CityRepository;
import com.woodyside.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final CityRepository cityRepository;
    private final HouseRepository houseRepository;
    private final AddressRepository addressRepository;

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public List<House> findAllHouses() {
        return houseRepository.findAll();
    }

    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }
}
