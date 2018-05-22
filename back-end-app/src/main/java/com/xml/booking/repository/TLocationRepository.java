package com.xml.booking.repository;

import com.xml.booking.domain.TLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TLocationRepository extends JpaRepository {

    public List<TLocation> findByAddressAndCityAndCountry(String address, String city, String country);
    public List<TLocation> findByCityAndCountry(String city, String country);
    public List<TLocation> findByAddressAndCity(String address, String city);

    public List<TLocation> findByCityLike(String city);
    public List<TLocation> findByAddressLike(String address);
    public List<TLocation> findByCountryLike(String country);

}