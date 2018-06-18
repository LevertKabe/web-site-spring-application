package com.pnpStore.controller;

//imported files for CategoryController class
import com.pnpStore.model.Category;
import com.pnpStore.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Marks that class is a Spring MVC Controller using REST API
@RestController
public class CategoryController {
    
    public List<Category> categoryList = new ArrayList<>();

    //use annotation to get rid ofthe setter emthod eg private Name name = new Name(); 
    @Autowired
    public CategoryService categoryService;
   
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value="/getCategory")
    public List<Category> getCategory()
    {
        categoryList = categoryService.getAllProducts();
        return categoryList;
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@PathVariable - identifies the patetrn of the paths incoming data - reads {x}
    //@RequestMethod - specifies method in which the request HTTP method ,GET - requests a specified resource
    @RequestMapping(value="/getCatByName/{catName}",  method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public Category getCatByName(@PathVariable String catName)
    {
        Category cat = new Category();
        
        cat = categoryService.getCategoryByName(catName);
        
        return cat;
    }
    
}
