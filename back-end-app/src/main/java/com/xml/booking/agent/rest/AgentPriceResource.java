package com.xml.booking.agent.rest;

import com.xml.booking.domain.TPrice;
import com.xml.booking.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price")
public class AgentPriceResource {

	@Autowired
	PriceService priceService;

	@GetMapping("/read")
	public ResponseEntity<List<TPrice>> getAccomodations() {
		List<TPrice> prices = priceService.findAll();
		return ResponseEntity.ok(prices);
	}

}
