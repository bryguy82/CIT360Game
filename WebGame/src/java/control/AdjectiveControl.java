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
import model.Adjective;
import model.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class AdjectiveControl implements Serializable {

    String urlSite = null;
    URL url = null;
    HttpURLConnection connect = null;
    BufferedReader reader = null;
    
    JSONParser jsonParser = new JSONParser();

    // String to hold the data
    String jsonData = null;
    
    public String httpAdjectiveBuilder() throws MalformedURLException, IOException, ParseException {
        
        urlSite = "https://raw.githubusercontent.com/bryguy82/CIT360Game/master/WebGame/src/java/data/adjectives.json";
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
        Object[] adjectiveObject = readJson(buffer.toString());
        
        // Globally set the adjective object in the game.
        Game game = new Game();
        game.setAdjectiveObject(adjectiveObject);
        return null;
    }
    
    public Object[] readJson(String buffer) throws IOException, ParseException {
        
        TreeSet<Integer> quantityTree;
        TreeSet<String> qualityTree = new TreeSet<>();
        TreeSet<String> sizeTree = new TreeSet<>();
        TreeSet<String> shapeTree = new TreeSet<>();
        TreeSet<String> colorTree = new TreeSet<>();
        
        try (StringReader readJson = new StringReader(buffer)) {
            // JSON object for the file
            JSONObject adjectiveObject = (JSONObject) jsonParser.parse(readJson);
            // JSON array for the adjectives
            JSONArray adjectiveArray = (JSONArray) adjectiveObject.get("adjectives");
            
            // Quantities
            quantityTree = buildAdjectiveQuantity();
            
            // Qualitites
            JSONObject qualityObject = (JSONObject) adjectiveArray.get(0);
            JSONArray qualityArray = (JSONArray) qualityObject.get("qualitites");
            // Loop through the string to set up the array
            for (int i = 0; i < qualityArray.size(); i++) {
                JSONObject adjective = (JSONObject) qualityArray.get(i);
                qualityTree.add(adjective.get("quality").toString());
            }
            
            // Size
            JSONObject sizeObject = (JSONObject) adjectiveArray.get(1);
            JSONArray sizeArray = (JSONArray) sizeObject.get("sizes");
            // Loop through the string to set up the array
            for (int i = 0; i < sizeArray.size(); i++) {
                JSONObject adjective = (JSONObject) sizeArray.get(i);
                sizeTree.add(adjective.get("size").toString());
            }
            
            // Shape
            JSONObject shapeObject = (JSONObject) adjectiveArray.get(2);
            JSONArray shapeArray = (JSONArray) shapeObject.get("shapes");
            // Loop through the string to set up the array
            for (int i = 0; i < shapeArray.size(); i++) {
                JSONObject adjective = (JSONObject) shapeArray.get(i);
                shapeTree.add(adjective.get("shape").toString());
            }
            
            // Color
            JSONObject colorObject = (JSONObject) adjectiveArray.get(3);
            JSONArray colorArray = (JSONArray) colorObject.get("colors");
            // Loop through the string to set up the array
            for (int i = 0; i < colorArray.size(); i++) {
                JSONObject adjective = (JSONObject) colorArray.get(i);
                colorTree.add(adjective.get("color").toString());
            }
        }
        Object[] adjectives = new String[5];
        adjectives[0] = quantityTree.toArray();
        adjectives[1] = qualityTree.toArray();
        adjectives[2] = sizeTree.toArray();
        adjectives[3] = shapeTree.toArray();
        adjectives[4] = colorTree.toArray();
        
        return adjectives;
    }
    
    public static TreeSet<Integer> buildAdjectiveQuantity() {
        // Create quantity tree
        TreeSet<Integer> addQuantity = new TreeSet<>();

        int min = 2;
        int max = 50;
        int value = 0;

        for (int i = 0; i < 20; i++) {
            value = (int) (Math.random() * (max - min) + 1);
            addQuantity.add(value);
        }
        return addQuantity;
    }
    
    public Object build(int selection, int listSize, Object[] adjectiveQuantityTree) {

        adjectiveQuantityTree = VocabularyControl.buildAdjectiveQuantity().toArray();
        Object[] adjectiveQualityTree = VocabularyControl.buildAdjectiveQuality().toArray();
        Object[] adjectiveSizeTree = VocabularyControl.buildAdjectiveSize().toArray();
        Object[] adjectiveShapeTree = VocabularyControl.buildAdjectiveShape().toArray();
        Object[] adjectiveColorTree = VocabularyControl.buildAdjectiveColor().toArray();

        //selection = (int) Math.round(Math.random() * (30 - 1));
        listSize = (int) Math.round(Math.random() * (4 - 0));

        if (selection < 0) {
            throw new ArrayIndexOutOfBoundsException("Number selected was less than zero.");
            //return -1
        }
        while (selection > adjectiveQuantityTree.length - 1) {
            if (selection > 20) {
                throw new ArrayIndexOutOfBoundsException("Number selected was greater than twenty.");
                //return -2
            }
            selection = selection - adjectiveQuantityTree.length;
        }

        Object[][] adjectiveOrder = buildTwoDimentionalArray(adjectiveQuantityTree, adjectiveQualityTree,
                adjectiveSizeTree, adjectiveShapeTree, adjectiveColorTree);

        Adjective adjective = new Adjective();

        // Select adjectives based on user input
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    adjective.setQuantity(adjectiveOrder[i][selection].toString());
                    break;
                case 1:
                    adjective.setQuality(adjectiveOrder[i][selection].toString());
                    break;
                case 2:
                    adjective.setSize(adjectiveOrder[i][selection].toString());
                    break;
                case 3:
                    adjective.setShape(adjectiveOrder[i][selection].toString());
                    break;
                default:
                    adjective.setColor(adjectiveOrder[i][selection].toString());
                    break;
            }
        }
        return adjective;
    }

    private static Object[][] buildTwoDimentionalArray(Object[] a, Object[] b, Object[] c, Object[] d, Object[] e) {

        Object[][] adjectiveOrder = new Object[5][a.length];
        // Populate two dimentional array[type][word]
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < a.length; j++) {
                switch (i) {
                    case 0:
                        adjectiveOrder[i][j] = a[j].toString();
                        break;
                    case 1:
                        adjectiveOrder[i][j] = b[j].toString();
                        break;
                    case 2:
                        adjectiveOrder[i][j] = c[j].toString();
                        break;
                    case 3:
                        adjectiveOrder[i][j] = d[j].toString();
                        break;
                    default:
                        adjectiveOrder[i][j] = e[j].toString();
                        break;
                }
            }
        }
        return adjectiveOrder;
    }
}
