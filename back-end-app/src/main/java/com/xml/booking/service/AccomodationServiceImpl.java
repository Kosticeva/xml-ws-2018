package com.xml.booking.service;

import com.xml.booking.agent.rest.dto.AgentAccomodationDTO;
import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.Image;
import com.xml.booking.domain.TLocation;
import com.xml.booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccomodationServiceImpl implements AccomodationService {

    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    AccomodationTypeRepository accomodationTypeRepository;

    @Autowired
    AccomodationServiceRepository accomodationServiceRepository;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TLocationRepository locationRepository;

    @Override
    public Accomodation save(Accomodation ac) {
        return this.accomodationRepository.save(ac);
    }

    @Override
    public Accomodation saveDTO(AgentAccomodationDTO accomodationDTO) {
        Accomodation ac = new Accomodation();
        ac.setAccommodationId(0);
        List<com.xml.booking.domain.AccomodationService> services = new ArrayList<>();
        for(int serviceId:accomodationDTO.getServices()) {
            services.add(accomodationServiceRepository.findById(serviceId).get());
        }
        List<Image> images = new ArrayList<>();
        for(String base64image:accomodationDTO.getImages()) {
            Image img = new Image(base64image);
            img.setId(0);
            images.add(imageRepository.save(img));
        }
        ac.setImages(images);
        ac.setAccomodationService(services);
        ac.setAccomodationType(accomodationTypeRepository.findById(accomodationDTO.getType()).get());
        ac.setAgent(agentRepository.findOneByUsername(accomodationDTO.getAgentUsername()));
        ac.setCategory(categoryRepository.findById(accomodationDTO.getCategory()).get());
        ac.setDescription(accomodationDTO.getDescription());
        ac.setMaxPersons(accomodationDTO.getMaxPersons());
        ac.setName(accomodationDTO.getName());
        TLocation location = new TLocation();
        location.setId(accomodationDTO.getAddress());
        location.setAddress(accomodationDTO.getAddress());
        location.setCity(accomodationDTO.getCity());
        location.setCountry(accomodationDTO.getCountry());
        ac.setLocation(locationRepository.save(location));
        return this.accomodationRepository.save(ac);
    }

    @Override
    public Accomodation get(int id) {
        return accomodationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Accomodation> findAll() {
        return accomodationRepository.findAll();
    }

    @Override
    public void delete(int id) {
        accomodationRepository.deleteById(id);
    }
}
