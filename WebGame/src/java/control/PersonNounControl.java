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
import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public class PersonNounControl implements Serializable {

    String urlSite = null;
    URL url = null;
    HttpURLConnection connect = null;
    BufferedReader reader = null;

    JSONParser jsonParser = new JSONParser();

    // String to hold the data
    String jsonData = null;

    public Object[] httpPersonNounBuilder() throws MalformedURLException, IOException, ParseException {

        urlSite = "https://raw.githubusercontent.com/bryguy82/CIT360Game/master/WebGame/src/java/data/personNouns.json";
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
        Object[] PersonNounArray = readJson(buffer.toString());

        // Globally set the person-noun array in the game.
        Game game = new Game();
        game.getTheGame().setPersonNounArray(PersonNounArray);

        return PersonNounArray;
    }

    public Object[] readJson(String buffer) throws IOException, ParseException {

        TreeSet<String> personNounTree = new TreeSet<>();

        try (StringReader readJson = new StringReader(buffer)) {
            // JSON object for the file
            JSONObject personNounObject = (JSONObject) jsonParser.parse(readJson);
            // JSON array for the person nouns
            JSONArray personNounArray = (JSONArray) personNounObject.get("personNouns");

            // Loop through the string to set up the array
            for (int i = 0; i < personNounArray.size(); i++) {
                JSONObject nounPerson = (JSONObject) personNounArray.get(i);
                personNounTree.add(nounPerson.get("person").toString());
            }
        }
        Object[] noun = personNounTree.toArray();
        return noun;
    }
}
