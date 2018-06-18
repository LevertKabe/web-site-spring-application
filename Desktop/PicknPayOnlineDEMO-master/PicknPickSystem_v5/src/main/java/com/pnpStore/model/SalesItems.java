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
//Create table name : SalesItems
@Table(name = "sales_items")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesItems.findAll", query = "SELECT s FROM SalesItems s")
    , @NamedQuery(name = "SalesItems.findByOrderno", query = "SELECT s FROM SalesItems s WHERE s.orderno = :orderno")
    , @NamedQuery(name = "SalesItems.findByCustid", query = "SELECT s FROM SalesItems s WHERE s.custid = :custid")
    , @NamedQuery(name = "SalesItems.findBySalesItem", query = "SELECT s FROM SalesItems s WHERE s.salesItem = :salesItem")})
public class SalesItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderno")
    private int orderno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "custid")
    private int custid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "salesItem")
    private Integer salesItem;

    //Default constructor
    public SalesItems() {
    }
    //Constructor
    public SalesItems(Integer salesItem) 
    {
        this.salesItem = salesItem;
    }
    //Constructor
    public SalesItems(Integer salesItem, int orderno, int custid) 
    {
        this.salesItem = salesItem;
        this.orderno = orderno;
        this.custid = custid;
    }
    //Setter and Getter methods for all attributes
    public int getOrderno() 
    {
        return orderno;
    }

    public void setOrderno(int orderno) 
    {
        this.orderno = orderno;
    }

    public int getCustid() 
    {
        return custid;
    }

    public void setCustid(int custid) 
    {
        this.custid = custid;
    }

    public Integer getSalesItem() 
    {
        return salesItem;
    }

    public void setSalesItem(Integer salesItem) 
    {
        this.salesItem = salesItem;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesItems)) {
            return false;
        }
        SalesItems other = (SalesItems) object;
        if ((this.salesItem == null && other.salesItem != null) || (this.salesItem != null && !this.salesItem.equals(other.salesItem))) {
            return false;
        }
        return true;
    }
 
}
