/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.TreeSet;
//import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Bryan
 */
public class WordBankControl implements Serializable {

    public WordBankControl() {
        // Empty constructor
    }

    /*-----------BUILD 3 NOUN TREES BELOW---------------------*/
 /*---------------Person Quantity------------------------17*/
    public static TreeSet<String> buildNounPersonQuantity() {

        TreeSet<String> addQuantity = new TreeSet<>();

        addQuantity.add("brother");
        addQuantity.add("sister");
        addQuantity.add("sibling");
        addQuantity.add("mother");
        addQuantity.add("father");
        addQuantity.add("grandfather");
        addQuantity.add("grandmother");
        addQuantity.add("aunt"); //an
        addQuantity.add("uncle"); //an
        addQuantity.add("cousin");
        addQuantity.add("husband");
        addQuantity.add("wife");
        addQuantity.add("daughter");
        addQuantity.add("son");
        addQuantity.add("parent");
        addQuantity.add("niece");
        addQuantity.add("nephew");

        return addQuantity;
    }

    /*---------------Place Quantity-------------------------18*/
 /*    public static TreeSet<String> buildNounPlaceQuantity() {
        
        TreeSet<String> addPlace = new TreeSet<>();
        
        addPlace.add("church");
        addPlace.add("bank");
        addPlace.add("park");
        addPlace.add("grocery store");
        addPlace.add("library");
        addPlace.add("airport"); //an
        addPlace.add("school");
        addPlace.add("restaurant");
        addPlace.add("movie theater");
        addPlace.add("museum");
        addPlace.add("zoo");
        addPlace.add("circus");
        addPlace.add("cemetery");
        addPlace.add("gym");
        addPlace.add("beauty salon");
        addPlace.add("barber shop");
        addPlace.add("stadium");
        addPlace.add("prison");
        
        return addPlace;
    }*/
 /*---------------Object Quantity------------------------18*/
    public static TreeSet<String> buildNounObjectQuantity() {

        TreeSet<String> addObject = new TreeSet<>();

        addObject.add("ball");
        addObject.add("backpack");
        addObject.add("sofa");
        addObject.add("calendar");
        addObject.add("computer");
        addObject.add("mirror");
        addObject.add("clock");
        addObject.add("pencil");
        addObject.add("pen");
        addObject.add("cell phone");
        addObject.add("television");
        addObject.add("notebook");
        addObject.add("radio");
        addObject.add("door");
        addObject.add("window");
        addObject.add("water bottle");
        addObject.add("table");
        addObject.add("chair");

        return addObject;
    }

    /*-----------BUILD 3 VERB TREES BELOW---------------------*/
 /*---------------Present Quantity-----------------------18*/
    public static TreeSet<String> buildVerbPresent() {

        TreeSet<String> addVerb = new TreeSet<>();

        addVerb.add("takes");
        addVerb.add("sees");
        addVerb.add("opens");
        addVerb.add("closes");
        addVerb.add("drives");
        addVerb.add("walks");
        addVerb.add("uses");
        addVerb.add("finds");
        addVerb.add("discovers");
        addVerb.add("gives");
        addVerb.add("calls");
        addVerb.add("needs");
        addVerb.add("becomes");
        addVerb.add("keeps");
        addVerb.add("helps");
        addVerb.add("shows");
        addVerb.add("moves");
        addVerb.add("pushes");

        return addVerb;
    }

    /*---------------Past Quantity--------------------------18*/
    public static TreeSet<String> buildVerbPast() {

        TreeSet<String> addVerb = new TreeSet<>();

        addVerb.add("took");
        addVerb.add("saw");
        addVerb.add("opened");
        addVerb.add("closed");
        addVerb.add("drove");
        addVerb.add("walked");
        addVerb.add("used");
        addVerb.add("found");
        addVerb.add("discovered");
        addVerb.add("gave");
        addVerb.add("called");
        addVerb.add("needed");
        addVerb.add("became");
        addVerb.add("kept");
        addVerb.add("helped");
        addVerb.add("showed");
        addVerb.add("moved");
        addVerb.add("pushed");

        return addVerb;
    }

    /*---------------Future Quantity------------------------18*/
    public static TreeSet<String> buildVerbFuture() {

        TreeSet<String> addVerb = new TreeSet<>();

        addVerb.add("will take");
        addVerb.add("will see");
        addVerb.add("will open");
        addVerb.add("will close");
        addVerb.add("will drive");
        addVerb.add("will walk");
        addVerb.add("will use");
        addVerb.add("will find");
        addVerb.add("will discover");
        addVerb.add("will give");
        addVerb.add("will call");
        addVerb.add("will need");
        addVerb.add("will become");
        addVerb.add("will keep");
        addVerb.add("will help");
        addVerb.add("will show");
        addVerb.add("will move");
        addVerb.add("will push");

        return addVerb;
    }

    /*----------BUILD 1 ADVERB TREE BELOW---------------------*/
 /*---------------BeforeBe Quantity----------------------18*/
    public static TreeSet<String> buildAdverbTree() {

        TreeSet<String> addAdverb = new TreeSet<>();

        addAdverb.add("immediately");
        addAdverb.add("doubtfully");
        addAdverb.add("innocently");
        addAdverb.add("adventurously");
        addAdverb.add("accidentally");
        addAdverb.add("selfishly");
        addAdverb.add("seriously");
        addAdverb.add("violently");
        addAdverb.add("suddenly");
        addAdverb.add("randomly");
        addAdverb.add("frantically");
        addAdverb.add("gently");
        addAdverb.add("courageously");
        addAdverb.add("mysteriously");
        addAdverb.add("rapidly");
        addAdverb.add("triumphantly");
        addAdverb.add("uselessly");
        addAdverb.add("enthusiastically");

        return addAdverb;
    }

    /*---------------Adverbs of Manner----------------------20*/
    // HOW
/*---------------Adverbs of Place-----------------------20*/
    // WHERE
/*---------------Adverbs of Time------------------------20*/
    // WHEN
/*---------------Adverbs of Frequency----------------------20*/
    // HOW OFTEN

    /*--------BUILD 5 ADJECTIVE TREES BELOW-------------------*/
 /*--------------Adjective Quantity----------------------20*/
    public static TreeSet<Integer> buildAdjectiveQuantity() {
        // Create quantity tree
        TreeSet<Integer> addQuantity = new TreeSet<>();

        int min = 2;
        int max = 50;

        for (int i = 0; i < 21; i++) {
            addQuantity.add((int) (Math.random() * (max - min) + 1));
        }
        /*
        for (int i = 0; i < 21; i++) {
            addQuantity.add(ThreadLocalRandom.current().nextInt(2, 70));
        } // An amazing random number generator between values
         */
        return addQuantity;
    }

    /*--------------Adjective Quality-----------------------20*/
    public static TreeSet<String> buildAdjectiveQuality() {
        // Create quality tree
        TreeSet<String> addQuality = new TreeSet<>();

        // Add to the tree
        addQuality.add("clever");
        addQuality.add("beautiful");
        addQuality.add("sweet");
        addQuality.add("good");
        addQuality.add("bold");
        addQuality.add("strong");
        addQuality.add("honest");
        addQuality.add("kind");
        addQuality.add("moist");
        addQuality.add("sticky");
        addQuality.add("wet");
        addQuality.add("hairy");
        addQuality.add("slimy");
        addQuality.add("dry");
        addQuality.add("oily");
        addQuality.add("hard");
        addQuality.add("soft");
        addQuality.add("chilly");
        addQuality.add("stiff");
        addQuality.add("sharp");

        return addQuality;
    }

    /*--------------Adjective Size--------------------------20*/
    public static TreeSet<String> buildAdjectiveSize() {
        // Create size tree
        TreeSet<String> addSize = new TreeSet<>();

        // Add to the tree
        addSize.add("puny");
        addSize.add("large");
        addSize.add("scrawny");
        addSize.add("little");
        addSize.add("short");
        addSize.add("tall");
        addSize.add("giant");
        addSize.add("gigantic");
        addSize.add("huge");
        addSize.add("massive");
        addSize.add("tiny");
        addSize.add("medium");
        addSize.add("enormous");
        addSize.add("narrow");
        addSize.add("thin");
        addSize.add("fat");
        addSize.add("bite sized");
        addSize.add("immense");
        addSize.add("miniscule");
        addSize.add("thick");

        return addSize;
    }

    /*--------------Adjective Shape-------------------------20*/
    public static TreeSet<String> buildAdjectiveShape() {
        // Create shape tree
        TreeSet<String> addShape = new TreeSet<>();

        // Add to the tree
        addShape.add("distorted");
        addShape.add("flat");
        addShape.add("round");
        addShape.add("chubby");
        addShape.add("fluffy");
        addShape.add("circular");
        addShape.add("square");
        addShape.add("oval");
        addShape.add("crooked");
        addShape.add("hollow");
        addShape.add("curved");
        addShape.add("straight");
        addShape.add("cylindrical");
        addShape.add("triangular");
        addShape.add("wide");
        addShape.add("rectangular");
        addShape.add("cubed");
        addShape.add("spherical");
        addShape.add("deformed");
        addShape.add("pointed");

        return addShape;
    }

    /*--------------Adjective Color-------------------------20*/
    public static TreeSet<String> buildAdjectiveColor() {
        // Create color tree
        TreeSet<String> addColor = new TreeSet<>();

        // Add to the tree
        addColor.add("gray");
        addColor.add("pink");
        addColor.add("black");
        addColor.add("green");
        addColor.add("purple");
        addColor.add("blue");
        addColor.add("mustard");
        addColor.add("red");
        addColor.add("yellow");
        addColor.add("brown");
        addColor.add("orange");
        addColor.add("white");
        addColor.add("gold");
        addColor.add("violet");
        addColor.add("fluorescent");
        addColor.add("multicolored");
        addColor.add("aqua");
        addColor.add("lavender");
        addColor.add("Navy blue");
        addColor.add("turquoise");

        return addColor;
    }
}
