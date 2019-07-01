/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

//import cit360.CIT360;
import java.io.Serializable;
import model.Verb;

/**
 *
 * @author Bryan
 */
public class VerbControl implements Serializable, WordSelectorArrayControl {

    public Object build(int selection, int listSize, Object[] verbPresentArray) {

        verbPresentArray = WordBankControl.buildVerbPresent().toArray();
        Object[] verbPastArray = WordBankControl.buildVerbPast().toArray();
        Object[] verbFutureArray = WordBankControl.buildVerbFuture().toArray();

        //selection = (int) Math.round(Math.random() * (30 - 1));
        listSize = (int) Math.round(Math.random() * (2 - 0));

        if (selection < 0) {
            throw new ArrayIndexOutOfBoundsException("Number selected was less than zero.");
            //return -1
        }
        while (selection > verbPresentArray.length - 1) {
            if (selection > 20) {
                throw new ArrayIndexOutOfBoundsException("Number selected was greater than twenty.");
                //return -2
            }
            selection = selection - verbPresentArray.length;
        }

        Object[][] verbTenses = new Object[3][verbPresentArray.length];
        // Populate two dimentional array[tense][word]
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < verbPresentArray.length; j++) {
                switch (i) {
                    case 0:
                        verbTenses[i][j] = verbPresentArray[j].toString();
                        break;
                    case 1:
                        verbTenses[i][j] = verbPastArray[j].toString();
                        break;
                    default:
                        verbTenses[i][j] = verbFutureArray[j].toString();
                        break;
                }
            }
        }

        Verb verb = new Verb();
        verb.setVerb(verbTenses[listSize][selection].toString());

        return verb;
    }

    /*
    public static void VerbSelect(int counter, int list) {

        String verb = "";
        // Convert TreeSets to String[]
        Object[] verbPresentArray = WordBankControl.buildVerbPresent().toArray();
        Object[] verbPastArray = WordBankControl.buildVerbPast().toArray();
        Object[] verbFutureArray = WordBankControl.buildVerbFuture().toArray();

        while (counter > verbPresentArray.length) {
            counter = counter - verbPresentArray.length / 2;
        }
        Object[][] verbTenses = new Object[3][verbPresentArray.length];
        // Populate two dimentional array[tense][word]
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < verbPresentArray.length; j++) {
                switch (i) {
                    case 0:
                        verbTenses[i][j] = verbPresentArray[j].toString();
                        break;
                    case 1:
                        verbTenses[i][j] = verbPastArray[j].toString();
                        break;
                    default:
                        verbTenses[i][j] = verbFutureArray[j].toString();
                        break;
                }
            }
        }

        verb = verbTenses[list][counter].toString();

        //CIT360.getCurrentGame().getWordBank().setVerb(verb);
    }
     */
}
