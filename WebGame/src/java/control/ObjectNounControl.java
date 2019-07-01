/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

//import cit360.CIT360;
import java.io.Serializable;
import model.ObjectNoun;

/**
 *
 * @author Bryan
 */
public class ObjectNounControl implements Serializable, WordSelectorControl {

    public Object build(int selection, Object[] objectArray) {

        objectArray = WordBankControl.buildNounObjectQuantity().toArray();
        //selection = (int) Math.round(Math.random() * (30 - 1));

        if (selection < 0) {
            throw new ArrayIndexOutOfBoundsException("Number selected was less than zero.");
            //return -1
        }
        while (selection > objectArray.length - 1) {
            if (selection > 20) {
                throw new ArrayIndexOutOfBoundsException("Number selected was greater than twenty.");
                //return -2
            }
            selection = selection - objectArray.length;
        }

        ObjectNoun objectNoun = new ObjectNoun();
        objectNoun.setObject(objectArray[selection].toString());

        return objectNoun;
    }
}
