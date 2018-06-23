package com.xml.booking.service;

import com.xml.booking.domain.Category;

import java.util.List;

public interface CategoryService {

	Category save(Category cat);
	boolean delete(String id);
	List<Category> getAll();
	List<Category> findAll();

}
