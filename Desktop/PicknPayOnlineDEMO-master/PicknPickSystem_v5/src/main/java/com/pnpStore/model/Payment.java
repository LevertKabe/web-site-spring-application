package com.pnpStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Hibernate annotation creates a Customer entity bean 
@Entity
//Create table name : Payment
@Table(name = "payment")
public class Payment{

    @Id
    @Column(name = "creditcardnum")
    private String creditcardnum;
    
    @Column(name = "custid")
    private int custID;
    
    @Column(name = "paytype")
    private String paytype;

    @Column(name = "paydate")
    private String paydate;
    
    @Column(name = "bank")
    private String bank;

    //Default constructor
    public Payment() {
    }
    //Constructor
    public Payment(String creditcardnum, int custID, String paytype, String paydate, String bank) {
        this.creditcardnum = creditcardnum;
        this.custID = custID;
        this.paytype = paytype;
        this.paydate = paydate;
        this.bank = bank;
    } 
    //Setter and Getter methods for all attributes
    public String getcreditcardnum() {
        return creditcardnum;
    }

    public void setcreditcardnum(String creditcardnum) {
        this.creditcardnum = creditcardnum;
    }

    public int getCustID()
    {
	return custID;
    }
    
    public void setCustID(int custID) 
    {
	this.custID = custID;
    }
    
    public String getpaytype() {
        return paytype;
    }

    public void setpaytype(String paytype) {
        this.paytype = paytype;
    }
    
    public String getpaydate() {
        return paydate;
    }

    public void setpaydate(String paydate) {
        this.paydate = paydate;
    }
    
    public String getbank() {
        return bank;
    }

    public void setbank(String bank) {
        this.bank = bank;
    }
}
