package com.example.productcategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productcategory.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
