package com.pnpStore.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Hibernate annotation creates a Category entity bean 
@Entity
//Create table name : Category
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    //Set Primary annotation
    @Id
    //Auto generate numbers/Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryID")
    private int categoryID;
    
    @Column(name = "categoryName")
    private String categoryName;

    //Default constructor
    public Category() {
    }
    //Constructor
    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }
    //Setter and Getter methods for all attributes
    public int getCategoryID() 
    {
        return categoryID;
    }

    public void setCategoryID(int categoryID) 
    {
        this.categoryID = categoryID;
    }
    
    public String getCategoryName() 
    {
        return categoryName;
    }

    public void setCategoryName(String custID) 
    {
        this.categoryName = categoryName;
    }
    
}
