package com.pnpStore.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

//Hibernate annotation creates a Customer entity bean 
@Entity
//Create table name : Inventoryitem
@Table(name = "inventoryitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventoryitem.findAll", query = "SELECT i FROM Inventoryitem i")
    , @NamedQuery(name = "Inventoryitem.findByInventoryid", query = "SELECT i FROM Inventoryitem i WHERE i.inventoryid = :inventoryid")
    , @NamedQuery(name = "Inventoryitem.findByBarcode", query = "SELECT i FROM Inventoryitem i WHERE i.barcode = :barcode")
    , @NamedQuery(name = "Inventoryitem.findByQuantity", query = "SELECT i FROM Inventoryitem i WHERE i.quantity = :quantity")})
public class Inventoryitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventoryid")
    private Integer inventoryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "barcode")
    private int barcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;

    //Default constructor
    public Inventoryitem() {
    }
    //Constructor
    public Inventoryitem(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }
    //Constructor
    public Inventoryitem(Integer inventoryid, int barcode, int quantity) {
        this.inventoryid = inventoryid;
        this.barcode = barcode;
        this.quantity = quantity;
    }
    //Setter and Getter methods for all attributes
    public Integer getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryid != null ? inventoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Inventoryitem)) {
            return false;
        }
        Inventoryitem other = (Inventoryitem) object;
        if ((this.inventoryid == null && other.inventoryid != null) || (this.inventoryid != null && !this.inventoryid.equals(other.inventoryid))) {
            return false;
        }
        return true;
    }
    
}
