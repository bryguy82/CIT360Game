/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import model.Adjective;

/**
 *
 * @author Bryan
 */
public class AdjectiveControl implements Serializable, WordSelectorArrayControl {

    @Override
    public Object build(int selection, int listSize, Object[] adjectiveQuantityTree) {

        adjectiveQuantityTree = WordBankControl.buildAdjectiveQuantity().toArray();
        Object[] adjectiveQualityTree = WordBankControl.buildAdjectiveQuality().toArray();
        Object[] adjectiveSizeTree = WordBankControl.buildAdjectiveSize().toArray();
        Object[] adjectiveShapeTree = WordBankControl.buildAdjectiveShape().toArray();
        Object[] adjectiveColorTree = WordBankControl.buildAdjectiveColor().toArray();

        //selection = (int) Math.round(Math.random() * (30 - 1));
        listSize = (int) Math.round(Math.random() * (4 - 0));

        if (selection < 0) {
            throw new ArrayIndexOutOfBoundsException("Number selected was less than zero.");
            //return -1
        }
        while (selection > adjectiveQuantityTree.length - 1) {
            if (selection > 20) {
                throw new ArrayIndexOutOfBoundsException("Number selected was greater than twenty.");
                //return -2
            }
            selection = selection - adjectiveQuantityTree.length;
        }

        Object[][] adjectiveOrder = buildTwoDimentionalArray(adjectiveQuantityTree, adjectiveQualityTree,
                adjectiveSizeTree, adjectiveShapeTree, adjectiveColorTree);

        Adjective adjective = new Adjective();

        // Select adjectives based on user input
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    adjective.setQuantity(adjectiveOrder[i][selection].toString());
                    break;
                case 1:
                    adjective.setQuality(adjectiveOrder[i][selection].toString());
                    break;
                case 2:
                    adjective.setSize(adjectiveOrder[i][selection].toString());
                    break;
                case 3:
                    adjective.setShape(adjectiveOrder[i][selection].toString());
                    break;
                default:
                    adjective.setColor(adjectiveOrder[i][selection].toString());
                    break;
            }
        }
        return adjective;
    }

    private static Object[][] buildTwoDimentionalArray(Object[] a, Object[] b, Object[] c, Object[] d, Object[] e) {

        Object[][] adjectiveOrder = new Object[5][a.length];
        // Populate two dimentional array[type][word]
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < a.length; j++) {
                switch (i) {
                    case 0:
                        adjectiveOrder[i][j] = a[j].toString();
                        break;
                    case 1:
                        adjectiveOrder[i][j] = b[j].toString();
                        break;
                    case 2:
                        adjectiveOrder[i][j] = c[j].toString();
                        break;
                    case 3:
                        adjectiveOrder[i][j] = d[j].toString();
                        break;
                    default:
                        adjectiveOrder[i][j] = e[j].toString();
                        break;
                }
            }
        }
        return adjectiveOrder;
    }
}
