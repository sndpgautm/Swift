/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTesting;

import Model.Employee;
import Model.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rocke
 */
public class EmployeeTest {
 
    @Test
    public void emptyConstructor() throws Exception{
        Employee e = new Employee();
        assertEquals(e.getName(), "unknown");
        assertEquals(e.getAddress(),"unknown");
        assertEquals(e.getEmployeeId(),0);
        assertEquals(e.getPosition(),null);
        assertEquals(e.getUsername(),"null");
    }
    
    @Test
    public void legalContructor() throws Exception {
        Employee e = new Employee("a", "abc 2", Position.COOK, "a12");
        assertEquals(e.getName(), "a");
        assertEquals(e.getAddress(),"abc 2");
        assertEquals(e.getEmployeeId(),0);
        assertEquals(e.getPosition(), Position.COOK);
        assertEquals(e.getUsername(),"a12");
    }
}
