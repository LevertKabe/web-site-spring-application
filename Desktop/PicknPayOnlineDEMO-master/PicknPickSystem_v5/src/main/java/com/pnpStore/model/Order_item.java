package com.pnpStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Hibernate annotation creates a Customer entity bean 
@Entity
//Create table name : Order_item
@Table(name = "order_item")
public class Order_item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderno")
    private int orderno;
    
    @Column(name = "custID")
    private int custID;
    
    @Column(name = "total")
    private double total;
    
    @Column(name = "orderdate")
    private String orderdate;

    //Default constructor
    public Order_item() {
    }
    //Constructor
    public Order_item(int orderno, int custID, double total, String orderdate) {
        this.orderno = orderno;
        this.custID = custID;
        this.total = total;
        this.orderdate = orderdate;
    }
    //Setter and Getter methods for all attributes
    public int getorderno() 
    {
        return orderno;
    }
    
    public void setorderno(int orderno)
    {
        this.orderno = orderno;
    }
    
    public int getCustID() 
    {
        return custID;
    }
    
    public void setCustID(int custID)
    {
        this.custID = custID;
    }
    
    public double gettotal() 
    {
        return total;
    }
    
    public void settotal(double total)
    {
        this.total = total;
    }
    
    public String getorderdate() 
    {
        return orderdate;
    }
    
    public void setorderdate(String orderdate)
    {
        this.orderdate = orderdate;
    }
   
    
}
