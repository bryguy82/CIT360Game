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
public class AdjectiveControlTest {
    
    public AdjectiveControlTest() {
    }
    
    @Test
    public void testVerbHttpObject() throws Exception {
        
        AdjectiveControl control = new AdjectiveControl();
        StringBuilder test1 = control.httpAdjectiveBuilder();
        StringBuilder test2 = null;
        
        assertNotNull(test1);
        assertNull(test2);
        
        Object[][] testObj1 = control.readJson(test1.toString());
        Object[][] testObj2 = control.readJson(test1.toString());
        
        assertArrayEquals(testObj1[1], testObj2[1]);
        assertArrayEquals(testObj1[2], testObj2[2]);
        assertArrayEquals(testObj1[3], testObj2[3]);
        assertArrayEquals(testObj1[4], testObj2[4]);
        
        int size = 20;
        assertEquals(testObj1.length, 5);
        assertEquals(size, testObj1[0].length);
        assertEquals(size, testObj1[1].length);
        assertEquals(size, testObj1[2].length);
        assertEquals(size, testObj1[3].length);
        assertEquals(size, testObj1[4].length);
        
        assertSame(testObj1[0][4], testObj1[0][4]);
        assertSame(testObj1[1][5], testObj1[1][5]);
        assertNotSame(testObj1[1][4], testObj1[0][4]);
        assertTrue(testObj1[0].length > 5);
        assertFalse(testObj1[2].length < 15);
        assertEquals(testObj2[2][8], "little");
    }

}
