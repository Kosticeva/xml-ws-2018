package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.*;
import com.ftn.xml.agent.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SyncService {

	@Autowired
	AgentRepository agentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccomodationServiceRepository accomodationServiceRepository;

	@Autowired
	AccomodationTypeRepository accomodationTypeRepository;

	@Autowired
	TPriceRepository priceRepository;

	@Autowired
	AccomodationRepository accomodationRepository;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	TLocationRepository locationRepository;

	@Autowired
	RestTemplate restTemplate;

	public void initializeOnLogin() {
		getUsers();
		getAgents();
		getAccomodationServices();
		getAccomodationTypes();
		getPrices();
		getCategories();
		getLocations();
		getAccomodations();
		getReservations();
		getMessages();
	}

	public void getUsers() {
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/user/read", User[].class);
		User[] users = responseEntity.getBody();

		for(User u:users) {
			System.out.println(u);
			userRepository.save(u);
		}
	}

	public void getAgents() {
		ResponseEntity<Agent[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/agent/read", Agent[].class);
		Agent[] agents = responseEntity.getBody();

		for(Agent a:agents) {
			System.out.println(a);
			agentRepository.save(a);
		}
	}

	public void getAccomodationServices() {
		ResponseEntity<AccomodationService[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/accomodationService/read", AccomodationService[].class);
		AccomodationService[] accomodationServices = responseEntity.getBody();

		for(AccomodationService a:accomodationServices) {
			System.out.println(a);
			accomodationServiceRepository.save(a);
		}
	}

	public void getAccomodationTypes() {
		ResponseEntity<AccomodationType[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/accomodationType/read", AccomodationType[].class);
		AccomodationType[] accomodationTypes = responseEntity.getBody();

		for(AccomodationType a:accomodationTypes) {
			System.out.println(a);
			accomodationTypeRepository.save(a);
		}
	}

	public void getPrices() {
		ResponseEntity<TPrice[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/price/read", TPrice[].class);
		TPrice[] prices = responseEntity.getBody();

		for(TPrice p:prices) {
			System.out.println(p);
			priceRepository.save(p);
		}
	}

	public void getCategories() {
		ResponseEntity<Category[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/category/read", Category[].class);
		Category[] categories = responseEntity.getBody();

		for(Category c:categories) {
			System.out.println(c);
			categoryRepository.save(c);
		}
	}

	public void getLocations() {
		ResponseEntity<TLocation[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/location/read", TLocation[].class);
		TLocation[] locations = responseEntity.getBody();

		for(TLocation l:locations) {
			System.out.println(l);
			locationRepository.save(l);
		}
	}

	public void getAccomodations() {
		ResponseEntity<Accomodation[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/accomodation/read", Accomodation[].class);
		Accomodation[] accomodations = responseEntity.getBody();

		for(Accomodation a:accomodations) {
			System.out.println(a);
			accomodationRepository.save(a);
		}
	}

	public void getReservations() {
		ResponseEntity<Reservation[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/reservation/read", Reservation[].class);
		Reservation[] reservations = responseEntity.getBody();

		for(Reservation r:reservations) {
			System.out.println(r);
			reservationRepository.save(r);
		}
	}

	public void getMessages() {
		ResponseEntity<Message[]> responseEntity = restTemplate.getForEntity("http://localhost:8091/message/read", Message[].class);
		Message[] messages = responseEntity.getBody();

		for(Message m:messages) {
			System.out.println(m);
			messageRepository.save(m);
		}
	}

}
