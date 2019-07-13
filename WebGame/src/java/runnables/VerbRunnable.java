/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.VerbControl;
import control.WordBankControl;
import java.io.IOException;
import model.Game;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class VerbRunnable implements Runnable {

    StringBuilder buffer = null;
    
    public VerbRunnable() {
        // Empty constructor
    }

    @Override
    public void run() {
        // declare an object
        Game game = new Game();
        VerbControl verb = new VerbControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();

        // TODO
        try {
            buffer = verb.httpVerbBuilder();
            Object[][] verbObject = verb.readJson(buffer.toString());
            game.getTheGame().setVerbDoubleArray(verbObject);
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
