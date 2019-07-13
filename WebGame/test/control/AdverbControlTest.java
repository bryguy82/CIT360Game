/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bryan
 */
public class AdverbControlTest {
    
    public AdverbControlTest() {
    }

    @Test
    public void testAdverbHttpObject() throws Exception {
        
        AdverbControl control = new AdverbControl();
        StringBuilder test1 = control.httpAdverbBuilder();
        StringBuilder test2 = null;
        
        assertNotNull(test1);
        assertNull(test2);
        
        Object[] testObj1 = control.readJson(test1.toString());
        Object[] testObj2 = control.readJson(test1.toString());
        
        assertArrayEquals(testObj1, testObj2);
        
        assertSame(testObj1[4], testObj1[4]);
        assertSame(testObj1[5], testObj1[5]);
        assertNotSame(testObj1[7], testObj1[6]);
        assertTrue(testObj1.length > 5);
        assertFalse(testObj1.length < 15);
        assertEquals(testObj2[8], "eagerly");
    }
}
