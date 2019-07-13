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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class ObjectNounControl implements Serializable {

    String urlSite = null;
    URL url = null;
    HttpURLConnection connect = null;
    BufferedReader reader = null;

    JSONParser jsonParser = new JSONParser();

    // String to hold the data
    String jsonData = null;

    public StringBuilder httpObjectNounBuilder() throws MalformedURLException, IOException, ParseException {

        urlSite = "https://raw.githubusercontent.com/bryguy82/CIT360Game/master/WebGame/src/java/data/objectNouns.json";
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

    public Object[] readJson(String buffer) throws IOException, ParseException {

        TreeSet<String> objectNounTree = new TreeSet<>();

        try (StringReader readJson = new StringReader(buffer)) {
            // JSON object for the file
            JSONObject objectNounObject = (JSONObject) jsonParser.parse(readJson);
            // JSON array for the object nouns
            JSONArray objectNounArray = (JSONArray) objectNounObject.get("objectNouns");

            // Loop through the string to set up the array
            for (int i = 0; i < objectNounArray.size(); i++) {
                JSONObject nounObject = (JSONObject) objectNounArray.get(i);
                objectNounTree.add(nounObject.get("object").toString());
            }
        }
        Object[] object = objectNounTree.toArray();
        return object;
    }
}
