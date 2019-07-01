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
public class PersonNoun implements Serializable {

    private String person;

    public PersonNoun() {
        // Empty constructor
    }

    public PersonNoun(String person) {
        //setPerson(person);
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "person, place, or thing";
    }
}
