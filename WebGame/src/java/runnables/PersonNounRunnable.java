/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.PersonNounControl;
import control.WordBankControl;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class PersonNounRunnable implements Runnable {

    public PersonNounRunnable() {
        // Empty constructor
    }

    @Override
    public void run() {
        // declare an object
        PersonNounControl personNoun = new PersonNounControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();

        // TODO
        try {
            personNoun.httpPersonNounBuilder();
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
