package com.pnpStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Hibernate annotation creates a Cart entity bean 
@Entity
//Create table name : Cart
@Table(name = "cart")
public class Cart 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private int cart_id;
    
    @Column(name = "custID")
    private String custID;
    
    @Column(name = "barcode")
    private int barcode;
    
    @Column(name = "cartquantity")
    private int cartquantity;
    
    @Column(name = "cartprice")
    private int cartprice;

    //Default constructor
    public Cart() 
    {
    }
    //Constructor
    public Cart(int cart_id, String custID, int barcode, int cartquantity, int cartprice) 
    {
        this.cart_id = cart_id;
        this.custID = custID;
        this.barcode = barcode;
        this.cartquantity = cartquantity;
        this.cartprice = cartprice;
    }
    //Setter and Getter methods for all attributes
    public int getCartId() 
    {
        return cart_id;
    }

    public void setCartId(int cart_id) 
    {
        this.cart_id = cart_id;
    }
    
    public String getCustID() 
    {
        return custID;
    }

    public void setCustID(String custID) 
    {
        this.custID = custID;
    }
    
    public int getBarcode() 
    {
        return barcode;
    }

    public void setBarcode(int barcode) 
    {
        this.barcode = barcode;
    }
    
    public int getCartQuantity() 
    {
        return cartquantity;
    }

    public void setCartQuantity(int cartquantity) 
    {
        this.cartquantity = cartquantity;
    }
    
    public int getCartPrice() 
    {
        return cartprice;
    }

    public void setCartPrice(int cartprice) 
    {
        this.cartprice = cartprice;
    }
    
    
    
}