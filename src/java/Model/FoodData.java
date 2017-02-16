/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Rocke
 */
public class FoodData {
    
    private ArrayList<Food> menu = new ArrayList<Food>();
    
    public ArrayList<Food> getMenu() {
        return menu;
    }
    
    
    public FoodData() {
        menu.add(new Food(1, "A", "abc", 15.00));
        menu.add(new Food(2, "B", "bnm", 12.00));
    }
    
}
