/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.PersonNounControl;
import control.WordBankControl;
import java.io.IOException;
import model.Game;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class PersonNounRunnable implements Runnable {

    StringBuilder buffer = null;
    
    public PersonNounRunnable() {
        // Empty constructor
    }

    @Override
    public void run() {
        // declare an object
        Game game = new Game();
        PersonNounControl personNoun = new PersonNounControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();

        // TODO
        try {
            buffer = personNoun.httpPersonNounBuilder();
            Object[] personNounObject = personNoun.readJson(buffer.toString());
            game.getTheGame().setPersonNounArray(personNounObject);
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
