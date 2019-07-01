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
public class WordBank implements Serializable {

    private PersonNoun personNoun;
    private ObjectNoun objectNoun;
    private Verb verb;
    private Adverb adverb;
    private Adjective adjective;

//    public WordBank(PersonNoun personNoun, Adverb adverb, Verb verb, Adjective adjective, ObjectNoun objectNoun) {
//        setPersonNoun(personNoun);
//        setAdverb(adverb);
//        setVerb(verb);
//        setAdjective(adjective);
//        setObjectNoun(objectNoun);
//    }
    public WordBank() {
        // Empty contructor
    }

    public PersonNoun getPersonNoun() {
        return personNoun;
    }

    public void setPersonNoun(PersonNoun personNoun) {
        this.personNoun = personNoun;
    }

    public ObjectNoun getObjectNoun() {
        return objectNoun;
    }

    public void setObjectNoun(ObjectNoun objectNoun) {
        this.objectNoun = objectNoun;
    }

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    public Adverb getAdverb() {
        return adverb;
    }

    public void setAdverb(Adverb adverb) {
        this.adverb = adverb;
    }

    public Adjective getAdjective() {
        return adjective;
    }

    public void setAdjective(Adjective adjective) {
        this.adjective = adjective;
    }

    @Override
    public String toString() {
        return "";
    }
}
