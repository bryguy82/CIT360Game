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

    public StringBuilder httpAdjectiveBuilder() throws MalformedURLException, IOException, ParseException {

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

        return buffer;
    }

    public Object[][] readJson(String buffer) throws IOException, ParseException {

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
            JSONObject adjObject = (JSONObject) adjectiveArray.get(0);
            JSONArray qualityArray = (JSONArray) adjObject.get("qualities");
            // Loop through the string to set up the array
            for (int i = 0; i < qualityArray.size(); i++) {
                JSONObject adjective = (JSONObject) qualityArray.get(i);
                qualityTree.add(adjective.get("quality").toString());
            }

            // Size
            JSONArray sizeArray = (JSONArray) adjObject.get("sizes");
            // Loop through the string to set up the array
            for (int i = 0; i < sizeArray.size(); i++) {
                JSONObject adjective = (JSONObject) sizeArray.get(i);
                sizeTree.add(adjective.get("size").toString());
            }

            // Shape
            JSONArray shapeArray = (JSONArray) adjObject.get("shapes");
            // Loop through the string to set up the array
            for (int i = 0; i < shapeArray.size(); i++) {
                JSONObject adjective = (JSONObject) shapeArray.get(i);
                shapeTree.add(adjective.get("shape").toString());
            }

            // Color
            JSONArray colorArray = (JSONArray) adjObject.get("colors");
            // Loop through the string to set up the array
            for (int i = 0; i < colorArray.size(); i++) {
                JSONObject adjective = (JSONObject) colorArray.get(i);
                colorTree.add(adjective.get("color").toString());
            }
        }
        // Turn the trees into arrays
        Object[] quantity = quantityTree.toArray();
        Object[] quality = qualityTree.toArray();
        Object[] size = sizeTree.toArray();
        Object[] shape = shapeTree.toArray();
        Object[] color = colorTree.toArray();
        // Put these arrays into a double array
        Object[][] adjectiveOrder = buildTwoDimentionalArray(quantity, quality, size, shape, color);

        return adjectiveOrder;
    }

    public static TreeSet<Integer> buildAdjectiveQuantity() {
        // Create quantity tree
        TreeSet<Integer> addQuantity = new TreeSet<>();
        
        int min = 2;
        int max = 50;
        int value = 0;

        for (int i = 0; i < 20; i++) {
            value = (int) (Math.random() * (max - min) + 1);
            if (addQuantity.contains(value)) {
                i--; // Step backwards for duplicate values.
            }
            addQuantity.add(value);
        }
        return addQuantity;
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
