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
public class WordBankControlTest {
    
    public WordBankControlTest() {
    }

    @Test
    public void testGetAtomNum() {
        WordBankControl control = new WordBankControl();
        int expResult = 0;
        int result = control.getAtomNum().getAndIncrement();
        assertEquals(expResult, result);
        
        int expResult2 = 1;
        int result2 = control.getAtomNum().getAndIncrement();
        assertSame(expResult2, result2);
        
        int result3 = control.getAtomNum().getAndIncrement();
        assertTrue(result3 > expResult2);
        
        int result4 = control.getAtomNum().getAndIncrement();
        assertFalse(result3 == result4);
    }

    @Test
    public void testSetRandomNumber() {
        int expResult = 15;
        int min = 0;
        int max = 10;
        int result = WordBankControl.setRandomNumber(min, max);
        assertFalse(expResult == result);
        assertTrue(result >= min);
        assertTrue(result <= max);
    }
        
}
