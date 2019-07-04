/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.ObjectNounControl;
import control.WordBankControl;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class ObjectNounRunnable implements Runnable {

    public ObjectNounRunnable() {
        // Empty constructor
    }

    @Override
    public void run() {
        // declare an object
        ObjectNounControl objectNoun = new ObjectNounControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();

        // TODO
        try {
            objectNoun.httpObjectNounBuilder();
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
