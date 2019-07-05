/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Bryan
 */
public class Game implements Serializable {

    private static Game theGame;
    private Player thePlayer;
    private Object[] personNounArray;
    private Object[] adverbArray;
    private Object[][] verbDoubleArray;
    private Object[][] adjectiveDoubleArray;
    private Object[] objectNounArray;
    private Object[] placeNounArray;
    private Map<Integer, String> sentence;

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

    public Object[][] getVerbDoubleArray() {
        return verbDoubleArray;
    }

    public void setVerbDoubleArray(Object[][] verbDoubleArray) {
        this.verbDoubleArray = verbDoubleArray;
    }

    public Object[][] getAdjectiveDoubleArray() {
        return adjectiveDoubleArray;
    }

    public void setAdjectiveDoubleArray(Object[][] adjectiveDoubleArray) {
        this.adjectiveDoubleArray = adjectiveDoubleArray;
    }

    public Object[] getObjectNounArray() {
        return objectNounArray;
    }

    public void setObjectNounArray(Object[] objectNounArray) {
        this.objectNounArray = objectNounArray;
    }

    public Object[] getPlaceNounArray() {
        return placeNounArray;
    }

    public void setPlaceNounArray(Object[] placeNounArray) {
        this.placeNounArray = placeNounArray;
    }

    public Map<Integer, String> getSentence() {
        return sentence;
    }

    public void setSentence(Map<Integer, String> sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "Game " + theGame;
    }

}
