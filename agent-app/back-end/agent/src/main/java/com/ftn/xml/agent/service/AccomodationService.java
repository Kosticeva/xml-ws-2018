package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.Accomodation;
import com.ftn.xml.agent.repository.AccomodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AccomodationService {

    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    RestTemplate restTemplate;

    public Accomodation save(Accomodation ac) {
        //saveRemote
        ResponseEntity<Accomodation> res = restTemplate.postForEntity("http://localhost:8091/accomodation/create",
                ac, Accomodation.class);
        Accomodation a = res.getBody();
        System.out.println(a);
        return this.accomodationRepository.save(a);
    }

    public Accomodation get(int id) {
        return accomodationRepository.findById(id).orElse(null);
    }

    public List<Accomodation> findAll() {
        return accomodationRepository.findAll();
    }

    public void delete(int id) {
        accomodationRepository.deleteById(id);
    }
}
