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
public class Adverb implements Serializable {

    private String simpleAdverb;

    public Adverb() {
        // Empty contructor
    }

    public String getSimpleAdverb() {
        return simpleAdverb;
    }

    public void setSimpleAdverb(String simpleAdverb) {
        this.simpleAdverb = simpleAdverb;
    }

    @Override
    public String toString() {
        return "";
    }
}
