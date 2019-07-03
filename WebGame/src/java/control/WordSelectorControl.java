/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.net.MalformedURLException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
public interface WordSelectorControl {

    Object build(int a, Object[] speechPart);
    
    String httpBuilder() throws MalformedURLException, IOException, ParseException;
    
    //String[] readJson(String buffer) throws IOException, ParseException;

}
