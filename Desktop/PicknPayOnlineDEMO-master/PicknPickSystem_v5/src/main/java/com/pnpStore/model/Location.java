/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "location")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByLocationID", query = "SELECT l FROM Location l WHERE l.locationID = :locationID")
    , @NamedQuery(name = "Location.findByAddressName", query = "SELECT l FROM Location l WHERE l.addressName = :addressName")
    , @NamedQuery(name = "Location.findByStreetNo", query = "SELECT l FROM Location l WHERE l.streetNo = :streetNo")
    , @NamedQuery(name = "Location.findByStreetName", query = "SELECT l FROM Location l WHERE l.streetName = :streetName")
    , @NamedQuery(name = "Location.findByState", query = "SELECT l FROM Location l WHERE l.state = :state")
    , @NamedQuery(name = "Location.findByCountry", query = "SELECT l FROM Location l WHERE l.country = :country")
    , @NamedQuery(name = "Location.findByCustID", query = "SELECT l FROM Location l WHERE l.custID = :custID")})
*/public class Location {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "locationID")
    private Integer locationID;
    @Size(max = 255)
    @Column(name = "addressName")
    private String addressName;
    @Column(name = "streetNo")
    private Integer streetNo;
    @Size(max = 255)
    @Column(name = "streetName")
    private String streetName;
    @Size(max = 255)
    @Column(name = "state")
    private String state;
    @Size(max = 255)
    @Column(name = "country")
    private String country;
    @Column(name = "custID")
    private Integer custID;

    public Location() {
    }

    public Location(Integer locationID) {
        this.locationID = locationID;
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCustID() {
        return custID;
    }

    public void setCustID(Integer custID) {
        this.custID = custID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationID != null ? locationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationID == null && other.locationID != null) || (this.locationID != null && !this.locationID.equals(other.locationID))) {
            return false;
        }
        return true;
    }

  
}
