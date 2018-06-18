package com.pnpStore.service;

import com.pnpStore.model.Category;
import com.pnpStore.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
	public CategoryRepository categoryRepository;
   
        public List<Category> getAllProducts()
        {
            List<Category> cat = new ArrayList<>();
            categoryRepository.findAll().
            forEach(cat::add);
            return cat;
        }
        
        public Category getCategoryByName(String catName)
        {
            Category cat = new Category();
            
            cat = categoryRepository.getCatByName(catName);
            
            return cat;
        }
}
