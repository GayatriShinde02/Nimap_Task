package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.model.Category;


@Repository
public interface CatProRepository extends JpaRepository<Category, Integer>
{

}
