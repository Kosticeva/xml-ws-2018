package com.xml.booking.service;

import com.xml.booking.domain.Category;
import com.xml.booking.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category save(Category cat) {
		return this.categoryRepository.save(cat);
	}

	@Override
	public boolean delete(String id) {
		if (this.categoryRepository.findById(Integer.parseInt(id)).isPresent()) {
			this.categoryRepository.delete(this.categoryRepository.findById(Integer.parseInt(id)).get());
			return true;
		}
		return false;
	}

	@Override
	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
