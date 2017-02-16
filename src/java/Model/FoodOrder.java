/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private List<Food> items;
    private OrderStatus status;
    
    public FoodOrder() {
        this(0, new ArrayList<Food>());
    };
    
    public FoodOrder(int tableNo, List<Food> items){
        this.orderId = 0L;
        this.tableNo = tableNo;
        this.items = items;
        this.status = OrderStatus.RECIEVED;
        this.total = 0;
        for (Food f : items) {
            this.total =+ f.getPrice();
        }
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
    @Enumerated(EnumType.ORDINAL)
    public OrderStatus getStatus() {
        return this.status;
    }
    
    
    @XmlElement
    @OneToMany (targetEntity=Food.class,
            fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    public List<Food> getItems() {
        return this.items;
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

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
    
    public void orderCooked() {
        this.status = OrderStatus.COOKED;
    }
    
    public void orderDelivered() {
        this.status = OrderStatus.DELIVERED;
    }
    
     
}
