package com.xml.booking.repository;

import com.xml.booking.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer> {

    public List<Category> findByCategoryIDIn(List<Integer> categoryIDs);

}
