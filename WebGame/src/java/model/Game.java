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
