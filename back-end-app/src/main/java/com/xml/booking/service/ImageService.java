package com.xml.booking.service;

import com.xml.booking.domain.Image;
import com.xml.booking.domain.TPrice;
import com.xml.booking.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

	@Autowired
	ImageRepository imageRepository;

	public List<Image> findAll() {
		return imageRepository.findAll();
	}
}
