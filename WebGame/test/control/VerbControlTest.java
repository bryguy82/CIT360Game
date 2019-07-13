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
public class VerbControlTest {
    
    public VerbControlTest() {
    }

    /**
     * Test of httpVerbBuilder method, of class VerbControl.
     */
    @Test
    public void testVerbHttpObject() throws Exception {
        
        VerbControl control = new VerbControl();
        StringBuilder test1 = control.httpVerbBuilder();
        StringBuilder test2 = null;
        
        assertNotNull(test1);
        assertNull(test2);
        
        Object[][] testObj1 = control.readJson(test1.toString());
        Object[][] testObj2 = control.readJson(test1.toString());
        
        assertArrayEquals(testObj1, testObj2);
        
        assertSame(testObj1[0][4], testObj1[0][4]);
        assertSame(testObj1[1][5], testObj1[1][5]);
        assertNotSame(testObj1[1][4], testObj1[0][4]);
        assertTrue(testObj1[0].length > 5);
        assertFalse(testObj1[2].length < 15);
        assertEquals(testObj2[2][8], "keep");
    }

    /**
     * Test of readJson method, of class VerbControl.
     */
    @Test
    public void testReadJson() throws Exception {
        String buffer = "{\"verbs\": [{\"pastTense\": [{\"past\": \"took\"},{\"past\": \"saw\"},{\"past\": \"opened\"}]},\n" +
"{\"presentTense\": [{\"present\": \"takes\"},{\"present\": \"sees\"},{\"present\": \"opens\"}]},\n" +
"{\"futureTense\": [{\"future\": \"take\"},{\"future\": \"see\"},{\"future\": \"open\"}]}]}";
        VerbControl control = new VerbControl();
        Object[][] result = control.readJson(buffer);
        assertNotNull(result);
    }

    /**
     * Test of buildTwoDimentionalArray method, of class VerbControl.
     */
    @Test
    public void testBuildTwoDimentionalArray() {
        System.out.println("buildTwoDimentionalArray");
        Object[] a = {"book", "doll"};
        Object[] b = {"shelves", "tables"};
        Object[] c = {"drink", "eat"};
        VerbControl control = new VerbControl();
        Object[][] expResult = new Object[3][2];
        expResult[0][0] = "book";
        expResult[0][1] = "doll";
        expResult[1][0] = "shelves";
        expResult[1][1] = "tables";
        expResult[2][0] = "drink";
        expResult[2][1] = "eat";
        
        Object[][] result = control.buildTwoDimentionalArray(a, b, c);
        assertArrayEquals(expResult, result);
        assertNotNull(result);
    }
}