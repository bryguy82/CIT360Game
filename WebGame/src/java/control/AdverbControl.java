/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import model.Adverb;
import model.Game;
//import cit360.CIT360;

/**
 *
 * @author Bryan
 */
public class AdverbControl implements Serializable, WordSelectorControl {

    public Object build(int selection, Object[] adverbArray) {

        adverbArray = WordBankControl.buildAdverbTree().toArray();
        //selection = (int) Math.round(Math.random() * (30 - 1));

        if (selection < 0) {
            throw new ArrayIndexOutOfBoundsException("Number selected was less than zero.");
            //return -1
        }
        while (selection > adverbArray.length - 1) {
            if (selection > 20) {
                throw new ArrayIndexOutOfBoundsException("Number selected was greater than twenty.");
                //return -2
            }
            selection = selection - adverbArray.length;
        }

        Adverb adverb = new Adverb();
        adverb.setSimpleAdverb(adverbArray[selection].toString());

        return adverb;
    }
}
