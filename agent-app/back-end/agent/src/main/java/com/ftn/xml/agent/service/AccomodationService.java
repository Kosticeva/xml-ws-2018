package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.Accomodation;
import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.domain.Image;
import com.ftn.xml.agent.domain.TLocation;
import com.ftn.xml.agent.dto.AccomodationDTO;
import com.ftn.xml.agent.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccomodationService {

    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    AccomodationServiceRepository accomodationServiceRepository;

    @Autowired
    AccomodationTypeRepository accomodationTypeRepository;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    TLocationRepository locationRepository;

    @Autowired
    HttpSession session;

    @Autowired
    RestTemplate restTemplate;

    public Accomodation save(AccomodationDTO accomodationDTO) {

        System.out.println(accomodationDTO.getCategory());

        accomodationDTO.setCategory(1);

        ResponseEntity<Accomodation> res = restTemplate.postForEntity("http://localhost:8091/accomodation/create",
                accomodationDTO, Accomodation.class);
        Accomodation a = res.getBody();
        System.out.println(a);
        List<Image> images = new ArrayList<>();
        for(String img: accomodationDTO.getImages()) {
            images.add(imageRepository.save(new Image(img)));
        }
        locationRepository.save(a.getLocation());
        a.setImages(images);
        return accomodationRepository.save(a);
    }

    public Accomodation get(int id) {
        return accomodationRepository.findById(id).orElse(null);
    }

    public List<Accomodation> findAll(Agent a) {
        return accomodationRepository.findByAgent(a);
    }

    public void delete(int id) {
        accomodationRepository.deleteById(id);
    }
}
