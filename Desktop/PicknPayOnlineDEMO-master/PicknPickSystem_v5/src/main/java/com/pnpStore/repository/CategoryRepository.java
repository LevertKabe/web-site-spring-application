package com.pnpStore.repository;

import com.pnpStore.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>
{
    @Query("SELECT c FROM Category c WHERE c.categoryName = :catName")
    public Category getCatByName(@Param("catName") String catName);
}
