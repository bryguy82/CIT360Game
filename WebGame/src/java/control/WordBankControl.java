/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import model.Game;
import runnables.*;

/**
 *
 * @author Bryan
 */
public class WordBankControl implements Serializable {

    private final AtomicInteger atomNum = new AtomicInteger(0);

    public AtomicInteger getAtomNum() {
        return atomNum;
    }

    public WordBankControl() {
        // Empty constructor
    }

    public void buildWordBank() {

        ConcurrentMap<Integer, Runnable> threadController = new ConcurrentHashMap();

        // Create ACP hashMap for Http/JSON files
        threadController.put(0, new PersonNounRunnable());
        threadController.put(1, new AdverbRunnable());
        threadController.put(2, new VerbRunnable());
        threadController.put(3, new AdjectiveRunnable());
        threadController.put(4, new ObjectNounRunnable());
        threadController.put(5, new PersonNounRunnable());

        // Starting executors
        for (int i = 0; i < threadController.size(); i++) {
            Runnable task = threadController.get(i);
            task.run();
        }
    }

    public void wordSelection(int personNum, int adverbNum, int verbTenseNum, int verbNum,
            int adjectiveNum, int objectNum, int placeNum) {

        Game game = new Game();

        // necessary variables
        String future = "will ";
        String quantity = "";
        String quality = "";
        String size = "";
        String shape = "";
        String color = "";

        // Person Noun
        String person = (String) game.getTheGame().getPersonNounArray()[personNum];
        // Adverb
        String adverb = (String) game.getTheGame().getAdverbArray()[adverbNum];
        // Future "will"
        if (verbTenseNum == 2) {
            adverb = future.concat(adverb);
        }
        // Verb
        String verb = (String) game.getTheGame().getVerbDoubleArray()[verbTenseNum][verbNum];
        // Loop for adjectives
        for (int i = 0; i < game.getTheGame().getAdjectiveDoubleArray().length; i++) {
            switch (i) {
                case 0:
                    quantity = (String) game.getTheGame().getAdjectiveDoubleArray()[i][adjectiveNum];
                    break;
                case 1:
                    quality = (String) game.getTheGame().getAdjectiveDoubleArray()[i][adjectiveNum];
                    break;
                case 2:
                    size = (String) game.getTheGame().getAdjectiveDoubleArray()[i][adjectiveNum];
                    break;
                case 3:
                    shape = (String) game.getTheGame().getAdjectiveDoubleArray()[i][adjectiveNum];
                    break;
                default:
                    color = (String) game.getTheGame().getAdjectiveDoubleArray()[i][adjectiveNum];
                    break;
            }
        }
        // Object
        String object = (String) game.getTheGame().getObjectNounArray()[objectNum];
        // Place
        String place = (String) game.getTheGame().getPlaceNounArray()[placeNum];

        buildTheSentence(person, adverb, verb, quantity, quality, size, shape, color, object, place);
    }

    public void buildTheSentence(String person, String adverb, String verb,
            String quantity, String quality, String size, String shape, String color,
            String object, String place) {

        // Create some sentence structures using the variables above
        String sentence0 = "The " + person + " " + adverb + " " + verb + " the "
                + quantity + " " + quality + " " + size + " " + shape + " " + color + " "
                + object + "s.";

        String sentence1 = "The " + size + " " + person + " " + adverb + " " + verb + " the "
                + quantity + " " + quality + " " + shape + " " + color + " " + object + "s.";

        String sentence2 = "The " + quality + " " + person + " " + adverb + " " + verb + " the "
                + quantity + " " + size + " " + shape + " " + color + " " + object + "s.";

        String sentence3 = "The " + shape + " " + person + " " + adverb + " " + verb + " the "
                + quantity + " " + quality + " " + size + " " + color + " " + object + "s.";

        String sentence4 = "The " + shape + " " + person + " at the" + place + " " + adverb + " " + verb + " the "
                + quantity + " " + quality + " " + size + " " + color + " " + object + "s.";

        String sentence5 = "The " + shape + " " + person + " at the" + color + " " + place + " " + adverb + " " + verb + " the "
                + quantity + " " + quality + " " + size + " " + object + "s.";

        Map<Integer, String> sentenceMap = new HashMap<>();
        sentenceMap.put(0, sentence0);
        sentenceMap.put(1, sentence1);
        sentenceMap.put(2, sentence2);
        sentenceMap.put(3, sentence3);
        sentenceMap.put(4, sentence4);
        sentenceMap.put(5, sentence5);

        Game game = new Game();
        game.getTheGame().setSentence(sentenceMap);
    }

    public String assignTheSentence(int selection) {

        Game game = new Game();
        Map<Integer, String> sentenceMap = game.getTheGame().getSentence();
        String sentence = sentenceMap.get(selection);

        return sentence;
    }

    public static int setRandomNumber(int min, int max) {

        int value = (int) (Math.random() * (max - min) + 1);

        return value;
    }
}
