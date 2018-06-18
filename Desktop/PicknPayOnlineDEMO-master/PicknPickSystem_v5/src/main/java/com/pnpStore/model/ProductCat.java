package com.pnpStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

//Hibernate annotation creates a ProductCat entity bean 
@Entity
//Create table name : ProductCat
@Table(name = "product_cat")
public class ProductCat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryID")
    private int categoryID;
    
    @Column(name = "description")
    @NotEmpty(message = "*Please provide the decription of the product")
    private String description;

    //Default constructor
    public ProductCat() {
    }
    //Constructor
    public ProductCat(int categoryID, String description) {
        this.categoryID = categoryID;
        this.description = description;
    }
    //Setter and Getter methods for all attributes
    public int getCategoryID() 
    {
	return categoryID;
    }

    public void setCategoryID(int category) 
    {
	this.categoryID = category;
    }
    
    public String getCategoryDescription() 
    {
	return description;
    }

    public void setCategoryDescripton(String description) 
    {
	this.description = description;
    } 
}
