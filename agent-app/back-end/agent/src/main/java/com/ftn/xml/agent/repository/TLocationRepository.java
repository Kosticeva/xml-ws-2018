package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.TLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TLocationRepository extends JpaRepository<TLocation, String> {

    public List<TLocation> findByAddressAndCityAndCountry(String address, String city, String country);
    public List<TLocation> findByCityAndCountry(String city, String country);
    public List<TLocation> findByAddressAndCity(String address, String city);

    public List<TLocation> findByCityStartingWith(String city);
    public List<TLocation> findByAddressStartingWith(String address);
    public List<TLocation> findByCountryStartingWith(String country);

}
