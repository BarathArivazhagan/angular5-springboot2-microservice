package com.barath.inventory.app.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by barath on 17/03/18.
 */
@Entity
@Table(name = "inventory")
@IdClass(InventoryId.class)
public class Inventory implements Serializable {

    private static final long serialVersionUID = -2982238389365245074L;

    @Id
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Id
    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "QUANTITY")
    private int quantity;

    /**
     * Default Constructor for Inventory
     */
    public Inventory() {
        super();

    }

    public Inventory(String productName, String locationName, int quantity) {
        super();
        this.productName = productName;
        this.locationName = locationName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productName='" + productName + '\'' +
                ", locationName='" + locationName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

class InventoryId implements Serializable {

    private static final long serialVersionUID = 2562451468803136805L;


    private String productName;

    private String locationName;

    public InventoryId() {
        super();

    }

    public InventoryId(String productName, String locationName) {
        super();
        this.productName = productName;
        this.locationName = locationName;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InventoryId other = (InventoryId) obj;
        if (locationName == null) {
            if (other.locationName != null)
                return false;
        } else if (!locationName.equals(other.locationName))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "InventoryId [productName=" + productName + ", locationName=" + locationName + "]";
    }



}