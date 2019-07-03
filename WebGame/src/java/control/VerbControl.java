/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeSet;
import model.Game;
import model.Verb;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class VerbControl implements Serializable, WordSelectorArrayControl {

    String urlSite = null;
    URL url = null;
    HttpURLConnection connect = null;
    BufferedReader reader = null;
    
    JSONParser jsonParser = new JSONParser();

    // String to hold the data
    String jsonData = null;
    
    public String httpVerbBuilder() throws MalformedURLException, IOException, ParseException {
        
        urlSite = "https://raw.githubusercontent.com/bryguy82/CIT360Game/master/WebGame/src/java/data/verbs.json";
        url = new URL(urlSite);
        connect = (HttpURLConnection) url.openConnection();
        connect.setReadTimeout(3000);
        connect.setRequestMethod("GET");
        connect.connect();
        
        // Set up input stream to gather data
        InputStream inputStream = connect.getInputStream();
        StringBuilder buffer = new StringBuilder();
        if (inputStream == null) {
            return null;
        }
        reader = new BufferedReader(new InputStreamReader(inputStream));
        
        String lineHolder;
        while ((lineHolder = reader.readLine()) != null) {
            // Read in JSON file line by line
            buffer.append(lineHolder); //.append("\n");
        }
        
        if (buffer.length() == 0) {
            // nothing in the buffer
            return null;
        }
        
        // Close the connection and reader.
        if (connect != null) {
            connect.disconnect();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
            }
        }
        
        // Transform the tree into an array.
        Object[] verbObject = readJson(buffer.toString());
        
        // Globally set the verb object in the game.
        Game game = new Game();
        game.setVerbObject(verbObject);
        return null;
    }
    
    public Object[] readJson(String buffer) throws IOException, ParseException {
        
        TreeSet<String> presentTree = new TreeSet<>();
        TreeSet<String> pastTree = new TreeSet<>();
        TreeSet<String> futureTree = new TreeSet<>();
        
        try (StringReader readJson = new StringReader(buffer)) {
            // JSON object for the file
            JSONObject verbObject = (JSONObject) jsonParser.parse(readJson);
            // JSON array for the verbs
            JSONArray verbArray = (JSONArray) verbObject.get("verbs");
            
            // Present tense
            JSONObject presentVerbObject = (JSONObject) verbArray.get(0);
            JSONArray presentVerbArray = (JSONArray) presentVerbObject.get("presentTense");
            // Loop through the string to set up the array
            for (int i = 0; i < presentVerbArray.size(); i++) {
                JSONObject verb = (JSONObject) presentVerbArray.get(i);
                presentTree.add(verb.get("present").toString());
            }
            
            // Past tense
            JSONObject pastVerbObject = (JSONObject) verbArray.get(0);
            JSONArray pastVerbArray = (JSONArray) pastVerbObject.get("pastTense");
            // Loop through the string to set up the array
            for (int i = 0; i < pastVerbArray.size(); i++) {
                JSONObject verb = (JSONObject) pastVerbArray.get(i);
                pastTree.add(verb.get("past").toString());
            }
            
            // Future tense
            JSONObject futureVerbObject = (JSONObject) verbArray.get(0);
            JSONArray futureVerbArray = (JSONArray) futureVerbObject.get("futureTense");
            // Loop through the string to set up the array
            for (int i = 0; i < futureVerbArray.size(); i++) {
                JSONObject verb = (JSONObject) futureVerbArray.get(i);
                futureTree.add(verb.get("future").toString());
            }
        }
        Object[] verbs = new String[3];
        verbs[0] = presentTree.toArray();
        verbs[1] = pastTree.toArray();
        verbs[2] = futureTree.toArray();
        
        return verbs;
    }
    
    public Object build(int selection, int listSize, Object[] verbPresentArray) {

        verbPresentArray = VocabularyControl.buildVerbPresent().toArray();
        Object[] verbPastArray = VocabularyControl.buildVerbPast().toArray();
        Object[] verbFutureArray = VocabularyControl.buildVerbFuture().toArray();

        //selection = (int) Math.round(Math.random() * (30 - 1));
        listSize = (int) Math.round(Math.random() * (2 - 0));

        if (selection < 0) {
            throw new ArrayIndexOutOfBoundsException("Number selected was less than zero.");
            //return -1
        }
        while (selection > verbPresentArray.length - 1) {
            if (selection > 20) {
                throw new ArrayIndexOutOfBoundsException("Number selected was greater than twenty.");
                //return -2
            }
            selection = selection - verbPresentArray.length;
        }

        Object[][] verbTenses = new Object[3][verbPresentArray.length];
        // Populate two dimentional array[tense][word]
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < verbPresentArray.length; j++) {
                switch (i) {
                    case 0:
                        verbTenses[i][j] = verbPresentArray[j].toString();
                        break;
                    case 1:
                        verbTenses[i][j] = verbPastArray[j].toString();
                        break;
                    default:
                        verbTenses[i][j] = verbFutureArray[j].toString();
                        break;
                }
            }
        }

        Verb verb = new Verb();
        verb.setVerb(verbTenses[listSize][selection].toString());

        return verb;
    }

    /*
    public static void VerbSelect(int counter, int list) {

        String verb = "";
        // Convert TreeSets to String[]
        Object[] verbPresentArray = WordBankControl.buildVerbPresent().toArray();
        Object[] verbPastArray = WordBankControl.buildVerbPast().toArray();
        Object[] verbFutureArray = WordBankControl.buildVerbFuture().toArray();

        while (counter > verbPresentArray.length) {
            counter = counter - verbPresentArray.length / 2;
        }
        Object[][] verbTenses = new Object[3][verbPresentArray.length];
        // Populate two dimentional array[tense][word]
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < verbPresentArray.length; j++) {
                switch (i) {
                    case 0:
                        verbTenses[i][j] = verbPresentArray[j].toString();
                        break;
                    case 1:
                        verbTenses[i][j] = verbPastArray[j].toString();
                        break;
                    default:
                        verbTenses[i][j] = verbFutureArray[j].toString();
                        break;
                }
            }
        }

        verb = verbTenses[list][counter].toString();

        //CIT360.getCurrentGame().getWordBank().setVerb(verb);
    }
     */
}
