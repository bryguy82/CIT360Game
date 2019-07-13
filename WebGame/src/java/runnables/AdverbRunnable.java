/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.AdverbControl;
import control.WordBankControl;
import java.io.IOException;
import model.Game;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class AdverbRunnable implements Runnable {

    StringBuilder buffer = null;

    public AdverbRunnable() {
        // Empty constructor
    }

    @Override
    public void run() {
        // declare an object
        Game game = new Game();
        AdverbControl adverb = new AdverbControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();

        // TODO
        try {
            buffer = adverb.httpAdverbBuilder();
            Object[] adverbObject = adverb.readJson(buffer.toString());
            game.getTheGame().setAdverbArray(adverbObject);
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
