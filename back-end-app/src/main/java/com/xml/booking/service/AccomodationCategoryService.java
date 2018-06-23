package com.xml.booking.service;

import com.xml.booking.domain.Category;
import com.xml.booking.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationCategoryService {

    @Autowired
    private CategoryRepository accomodationCategoryRepository;

    public Category save(Category ac){
        return this.accomodationCategoryRepository.save(ac);
    }

    public boolean delete(String id) {
        if (this.accomodationCategoryRepository.findById(Integer.parseInt(id)).isPresent()) {
            this.accomodationCategoryRepository.delete(this.accomodationCategoryRepository.findById(Integer.parseInt(id)).get());;
            return true;
        }
        return false;
    }

    public List<com.xml.booking.domain.Category> getAll() {
        return this.accomodationCategoryRepository.findAll();
    }

    public Category get(int id) {
        return accomodationCategoryRepository.findById(id).get();
    }
}
