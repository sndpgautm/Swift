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
        menu.add(new Food("A", "abc", 15.00));
        menu.add(new Food("B", "bnm", 12.00));
        menu.add(new Food("D", "abcdssad", 16.00));
        menu.add(new Food("E", "bnmdffd", 13.00));
    }
    
}
