package com.pnpStore.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Hibernate annotation creates a Customer entity bean 
@Entity
//Create table name : Product
@Table(name = "product")

public class Product implements Serializable{
    
    	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "barcode")
	private int barcode;
        
        @Column(name = "prodname")
	private String prodname;
        
	@Column(name = "prodinfo")
	private String prodinfo;
        
        @Column(name = "productimg")
        private String productimg;
        

        @Column(name = "price")
        private double price;
        
        @Column(name = "categoryID")
        private int categoryID;
        
        //Default constructor
        public Product()
        {
        } 
        //Constructor
        public Product(String prod_info, String prodname, double price, String product_img, int categoryID)
        {
            this.prodinfo = prod_info;
            this.prodname = prodname;
            this.price = price;
            this.productimg = product_img;
            this.categoryID = categoryID;
        }
        
        //Setter and Getter methods for all attributes
        public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
        
        public String getProdName() {
		return prodname;
	}
        
        public void setProdName(String prod_name) {
		this.prodname = prod_name;
	}

        public String getProdInfo() {
		return prodinfo;
	}
        
        public void setProdInfo(String prod_info) {
		this.prodinfo = prod_info;
	}
        
        public String getProdImage() {
		return productimg;
	}

	public void setProdImage(String product_img) {
		this.productimg = product_img;
	}

        
        public double getPrice()
        {
            return price;
        }
        
        public void setPrice(double price)
        {
            this.price = price;
        }
        
        public int getCategoryID() 
        {
            return categoryID;
        }
        
        public void setCategoryID(int categoryID) 
        {
            this.categoryID = categoryID;
        }
}
