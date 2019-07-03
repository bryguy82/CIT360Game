/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import model.*;

/**
 *
 * @author Bryan
 */
public class CustomSentenceGameControl {

    public CustomSentenceGameControl() {

    }
/*
    public void buildsCustomSentence(String[] inputs) {

        WordBank wordBank = null;// = CIT360.getCurrentGame().getWordBank();

        // Save the random different parts of speech to the game's wordBank
        HashMap<String, WordSelectorControl> wordLists = new HashMap<>();
        wordLists.put("person", new PersonNounControl());
        wordLists.put("adverb", new AdverbControl());
        wordLists.put("object", new ObjectNounControl());

        HashMap<String, WordSelectorArrayControl> wordArrayLists = new HashMap<>();
        wordArrayLists.put("verb", new VerbControl());
        wordArrayLists.put("adjective", new AdjectiveControl());

        String[] partsOfSpeech = {"person", "adverb", "verb", "adjective", "object"};

        int personSelected = Integer.parseInt(inputs[0]);
        int adverbSelected = Integer.parseInt(inputs[1]);
        int verbSelected = Integer.parseInt(inputs[2]);
        int adjectiveSelected = Integer.parseInt(inputs[3]);
        int objectSelected = Integer.parseInt(inputs[4]);

        WordSelectorControl wordSelect;
        WordSelectorArrayControl wordSelectArray;
        // for loop with OR for both maps, then case statements
        for (int i = 0; i < wordLists.size() + wordArrayLists.size(); i++) {
            switch ((partsOfSpeech[i])) {
                case "person":
                    wordSelect = wordLists.get(partsOfSpeech[i]);
                    PersonNoun person = (PersonNoun) wordSelect.build(personSelected, partsOfSpeech);
                    wordBank.setPersonNoun(person);
                    break;
                case "adverb":
                    wordSelect = wordLists.get(partsOfSpeech[i]);
                    Adverb adverb = (Adverb) wordSelect.build(adverbSelected, partsOfSpeech);
                    wordBank.setAdverb(adverb);
                    break;
                case "verb":
                    wordSelectArray = wordArrayLists.get(partsOfSpeech[i]);
                    Verb verb = (Verb) wordSelectArray.build(verbSelected, i, partsOfSpeech);
                    wordBank.setVerb(verb);
                    break;
                case "adjective":
                    wordSelectArray = wordArrayLists.get(partsOfSpeech[i]);
                    Adjective adjective = (Adjective) wordSelectArray.build(adjectiveSelected, i, partsOfSpeech);
                    wordBank.setAdjective(adjective);
                    break;
                default:
                    wordSelect = wordLists.get(partsOfSpeech[i]);
                    ObjectNoun object = (ObjectNoun) wordSelect.build(objectSelected, partsOfSpeech);
                    wordBank.setObjectNoun(object);
                    break;
            }
        }
    }*/
}
