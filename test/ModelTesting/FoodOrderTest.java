/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTesting;

import Model.Food;
import Model.FoodData;
import Model.FoodOrder;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Rocke
 */
public class FoodOrderTest {
    
    @Test
    public void emptyConstructor() throws Exception {
        FoodOrder f = new FoodOrder();
        assertEquals(f.getOrderId(), new Long(0L));
        assertEquals(f.getTableNo(),0);
        assertEquals(f.getTotal(), 0.0, 0.02);
        assertEquals(f.getStatus(),"Order Received");
        
    }
    
    @Test
    public void legalConstructor() throws Exception {
        List<Food> foods = new ArrayList<Food>();
        FoodOrder f = new FoodOrder(1, foods, "a");
        assertEquals(f.getOrderId(), new Long(0L));
        assertEquals(f.getTableNo(), 1);
        assertEquals(f.getTotal(), 0.0, 0.02);
        assertEquals(f.getStatus(),"a");
        
    }
}
