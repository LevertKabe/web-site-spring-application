package com.pnpStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Hibernate annotation creates a Customer entity bean 
@Entity
//Create table name : Role
@Table(name = "role")
public class Role {
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	@Column(name="role")
	private String role;

        //Default constructor
        public Role() 
        {
        }
        //Constructor
        public Role(int id, String role) 
        {
            this.id = id;
            this.role = role;
        }
        //Setter and Getter methods for all attributes
	public int getId() {
		return id;
	}
        
	public void setId(int id) {
		this.id = id;
	}
        
	public String getRole() {
		return role;
	}
        
	public void setRole(String role) {
		this.role = role;
	}

}
