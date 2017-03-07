/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rocke
 */

@XmlRootElement
@Entity
public class FoodOrder implements Serializable {
    private Long orderId;
    private double total;
    private int tableNo;
    private Date orderPlacedAt;
    private List<Food> items;
    private String status;
    
    public FoodOrder() {
        this(0, new ArrayList<Food>(),"Order Received");
    };
    
    public FoodOrder(int tableNo, List<Food> items,String status){
        this.orderId = 0L;
        this.tableNo = tableNo;
        this.items = items;
        this.status = status;
        this.total = 0;
        for (Food f : this.items) {
            this.total = this.total + f.getPrice();
        }
        this.orderPlacedAt = new Date(); 
    }
    
    @XmlElement
    @Id
    @GeneratedValue
    public Long getOrderId() {
        return this.orderId;
    }
    
    @XmlElement
    @Basic
    public double getTotal() {
        return this.total;
    }
    
    @XmlElement
    @Basic
    public int getTableNo() {
        return this.tableNo;
    }
    
    @XmlElement
    @Basic
    public String getStatus() {
        return this.status;
    }
    
    
    
    @ManyToMany (targetEntity=Food.class,
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL)
    public List<Food> getItems() {
        return this.items;
    }

    @XmlElement
    @Temporal (TemporalType.TIMESTAMP)
    public Date getOrderPlacedAt() {
        return this.orderPlacedAt;
    }

    public void setOrderPlacedAt(Date orderPlacedAt) {
        this.orderPlacedAt = orderPlacedAt;
    }
    
    
    
    

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
    
    public void orderCooked() {
        this.status = "Order Cooked";
    }
    
    public void orderDelivered() {
        this.status = "Order Delivered";
    }
    
     
}
