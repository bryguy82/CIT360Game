/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Bryan
 */
public class Game implements Serializable {

    private Game theGame;
    private Player thePlayer;
    private WordBank wordBank;
    private Object[] personNounArray;
    private Object[] adverbArray;
    private Object[] verbObject;
    private Object[] adjectiveObject;
    private Object[] objectNounArray;
//    private Sentence sentence;

    public Game() {
        // Empty constructor        
    }

    public Game getTheGame() {
        return theGame;
    }

    public void setTheGame(Game theGame) {
        this.theGame = theGame;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public WordBank getWordBank() {
        return wordBank;
    }

    public void setWordBank(WordBank wordBank) {
        this.wordBank = wordBank;
    }

    public Object[] getPersonNounArray() {
        return personNounArray;
    }

    public void setPersonNounArray(Object[] personNounArray) {
        this.personNounArray = personNounArray;
    }

    public Object[] getAdverbArray() {
        return adverbArray;
    }

    public void setAdverbArray(Object[] adverbArray) {
        this.adverbArray = adverbArray;
    }

    public Object[] getVerbObject() {
        return verbObject;
    }

    public void setVerbObject(Object[] verbObject) {
        this.verbObject = verbObject;
    }

    public Object[] getAdjectiveObject() {
        return adjectiveObject;
    }

    public void setAdjectiveObject(Object[] adjectiveObject) {
        this.adjectiveObject = adjectiveObject;
    }

    public Object[] getObjectNounArray() {
        return objectNounArray;
    }

    public void setObjectNounArray(Object[] objectNounArray) {
        this.objectNounArray = objectNounArray;
    }

//    public String getTheSentence() {
//        return theSentence;
//    }
//
//    public void setTheSentence(String theSentence) {
//        this.theSentence = theSentence;
//    }
    @Override
    public String toString() {
        return "Game " + theGame;
    }

}
