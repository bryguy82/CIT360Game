/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.VerbControl;
import control.WordBankControl;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class VerbRunnable implements Runnable  {
    
    public VerbRunnable() {
        // Empty constructor
    }
    
    @Override
    public void run() {
        // declare an object
        VerbControl verb = new VerbControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();
        
        // TODO
        try {
            verb.httpVerbBuilder();
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
