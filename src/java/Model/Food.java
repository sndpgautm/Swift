/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rocke
 */
@XmlRootElement
@Entity
public class Food implements Serializable {
    
    private int foodId;
    private String foodName;
    private String ingredients;
    private double price;
    
    public Food(){
        this("null","null", 0.0);
    };
    
    public Food(String foodName, String indt, double price){
        this.foodId = 0;
        this.foodName = foodName;
        this.ingredients = indt;
        this.price = price;
    }

    @XmlElement
    @Id
    @GeneratedValue
    public int getFoodId() {
        return this.foodId;
    }

    @XmlElement
    @Basic
    public String getFoodName() {
        return this.foodName;
    }

    @XmlElement
    @Lob
    public String getIngredients() {
        return this.ingredients;
    }

    @XmlElement
    @Basic
    public double getPrice() {
        return this.price;
    }
    
    

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
}
