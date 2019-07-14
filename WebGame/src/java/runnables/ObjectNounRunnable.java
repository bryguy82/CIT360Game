/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.ObjectNounControl;
import control.WordBankControl;
import java.io.IOException;
import model.Game;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class ObjectNounRunnable implements Runnable {

    StringBuilder buffer = null;

    public ObjectNounRunnable() {
        // Empty constructor
    }

    @Override
    public void run() {
        // declare an object
        Game game = new Game();
        ObjectNounControl objectNoun = new ObjectNounControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();

        try {
            buffer = objectNoun.httpObjectNounBuilder();
            Object[] objectNounObject = objectNoun.readJson(buffer.toString());
            game.getTheGame().setObjectNounArray(objectNounObject);
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
