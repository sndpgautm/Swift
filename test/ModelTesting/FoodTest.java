/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTesting;

import Model.Food;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rocke
 */
public class FoodTest {
    
    @Test
    public void emptyConstructor() throws Exception {
        Food f = new Food();
        assertEquals(f.getFoodId(), 0);
        assertEquals(f.getFoodName(),"null");
        assertEquals(f.getIngredients(),"null");
        assertEquals(f.getPrice(), 0.0, 0.02);
        
    }
    
    @Test
    public void constructorLegal() throws Exception {
        Food f = new Food("a","abc",10.2);
        assertEquals(f.getFoodId(), 0);
        assertEquals(f.getFoodName(),"a");
        assertEquals(f.getIngredients(),"abc");
        assertEquals(f.getPrice(), 10.2, 0.02);
        
    }
}
