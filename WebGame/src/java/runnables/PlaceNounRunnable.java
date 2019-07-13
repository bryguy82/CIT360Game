/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

import control.PlaceNounControl;
import control.WordBankControl;
import java.io.IOException;
import model.Game;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class PlaceNounRunnable implements Runnable {

    StringBuilder buffer = null;
    
    @Override
    public void run() {
        // declare an object
        Game game = new Game();
        PlaceNounControl placeNoun = new PlaceNounControl();
        WordBankControl wordBank = new WordBankControl();
        wordBank.getAtomNum().getAndIncrement();

        // TODO
        try {
            buffer = placeNoun.httpPlaceNounBuilder();
            Object[] placeNounObject = placeNoun.readJson(buffer.toString());
            game.getTheGame().setPlaceNounArray(placeNounObject);
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
