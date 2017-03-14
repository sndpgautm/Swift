/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTesting;

import Model.userAccount;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Rocke
 */
public class userAccountTest {
    
    @Test
    public void emptyContructor(){
        userAccount u = new userAccount();
        assertEquals(u.getUsername(), "null");
        assertEquals(u.getPassword(), "null");
    }
    
    @Test
    public void legalContructor() {
        userAccount u = new userAccount("san", "pass");
        assertEquals(u.getUsername(),"san");
        assertEquals(u.getPassword(), "pass");
    }
}
