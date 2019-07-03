/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.AdjectiveControl;
import control.WordBankControl;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class AdjectiveRunnable implements Runnable  {
    
    public AdjectiveRunnable() {
        // Empty constructor
    }
    
    @Override
    public void run() {
        // declare an object
        AdjectiveControl adjective = new AdjectiveControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();
        
        // TODO
        try {
            adjective.httpAdjectiveBuilder();
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
