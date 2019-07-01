/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import model.PersonNoun;

/**
 *
 * @author Bryan
 */
public class PersonNounControl implements Serializable, WordSelectorControl {

    public Object build(int selection, Object[] personArray) {

        personArray = WordBankControl.buildNounPersonQuantity().toArray();
        //selection = (int) Math.round(Math.random() * (30 - 1));

        if (selection < 0) {
            throw new ArrayIndexOutOfBoundsException("Number selected was less than zero.");
            //return -1
        }
        while (selection > personArray.length - 1) {
            if (selection > 20) {
                throw new ArrayIndexOutOfBoundsException("Number selected was greater than twenty.");
                //return -2
            }
            selection = selection - personArray.length;
        }

        PersonNoun personNoun = new PersonNoun();
        personNoun.setPerson(personArray[selection].toString());

        return personNoun;
    }
}
