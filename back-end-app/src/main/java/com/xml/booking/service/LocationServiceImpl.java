package com.xml.booking.service;

import com.xml.booking.domain.TLocation;
import com.xml.booking.repository.TLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	TLocationRepository locationRepository;

	@Override
	public List<TLocation> findAll() {
		return locationRepository.findAll();
	}

}
