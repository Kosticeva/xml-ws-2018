package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer> {

    public List<Category> findByCategoryIDIn(List<Integer> categoryIDs);

}
