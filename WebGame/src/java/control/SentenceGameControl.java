/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
//import java.util.concurrent.ThreadLocalRandom;
import model.*;

/**
 *
 * @author Bryan
 */
public class SentenceGameControl {

    public SentenceGameControl() {
        // Empty contructor
    }
/*
    public static Game createNewSentenceGame(String playerName) {

        Player player = new Player();
        Game game = new Game();
        WordBank wordBank = new WordBank();

        player.setName(playerName);
        game.setThePlayer(player);
        game.setWordBank(wordBank);

        return game;
    }

    public static WordBank makeASentence() {

        // Word objects
        WordBank wordBank = new WordBank();
        PersonNoun person = null;
        Adverb adverb = null;
        Verb verb = null;
        Adjective adjective = null;
        ObjectNoun object = null;

        // Save the random different parts of speech to the game's wordBank
        HashMap<String, WordSelectorControl> wordLists = new HashMap<>();
        wordLists.put("person", new PersonNounControl());
        wordLists.put("adverb", new AdverbControl());
        wordLists.put("object", new ObjectNounControl());

        HashMap<String, WordSelectorArrayControl> wordArrayLists = new HashMap<>();
        wordArrayLists.put("verb", new VerbControl());
        wordArrayLists.put("adjective", new AdjectiveControl());

        String[] partsOfSpeech = {"person", "adverb", "verb", "adjective", "object"};

        int random = (int) Math.round(Math.random() * (20 - 1));
        WordSelectorControl wordSelect;
        WordSelectorArrayControl wordSelectArray;
        // for loop with OR for both maps, then case statements
        for (int i = 0; i < wordLists.size() + wordArrayLists.size(); i++) {
            switch ((partsOfSpeech[i])) {
                case "person":
                    wordSelect = wordLists.get(partsOfSpeech[i]);
                    person = (PersonNoun) wordSelect.build(random, partsOfSpeech);
                    break;
                case "adverb":
                    wordSelect = wordLists.get(partsOfSpeech[i]);
                    adverb = (Adverb) wordSelect.build(random, partsOfSpeech);
                    break;
                case "verb":
                    wordSelectArray = wordArrayLists.get(partsOfSpeech[i]);
                    verb = (Verb) wordSelectArray.build(random, i, partsOfSpeech);
                    break;
                case "adjective":
                    wordSelectArray = wordArrayLists.get(partsOfSpeech[i]);
                    adjective = (Adjective) wordSelectArray.build(random, i, partsOfSpeech);
                    break;
                default:
                    wordSelect = wordLists.get(partsOfSpeech[i]);
                    object = (ObjectNoun) wordSelect.build(random, partsOfSpeech);
                    break;
            }
        }

        wordBank.setPersonNoun(person);
        wordBank.setAdverb(adverb);
        wordBank.setVerb(verb);
        wordBank.setAdjective(adjective);
        wordBank.setObjectNoun(object);

        return wordBank;
    }*/
}
