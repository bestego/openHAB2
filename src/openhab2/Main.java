/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import static java.nio.file.Files.newBufferedReader;
import java.nio.file.Paths;

/**
 *
 * @author erik
 */
public class Main {

    public static void main(String... args) throws IOException {
        Rules itemRules = new Rules();
        itemRules.loadFile(Paths.get("items.txt"));
        Rules commandRules = new Rules();
        commandRules.loadFile(Paths.get("actions.txt"));
        Rules valueRules = new Rules();
        valueRules.loadFile(Paths.get("parameters.txt"));
        
        Translator itemXlate = new Translator();
        itemXlate.setRules(itemRules);
        Translator commandXlate = new Translator();
        commandXlate.setRules(commandRules);
        Translator valueXlate= new Translator();
        valueXlate.setRules(valueRules);

        String line;
        try {
            BufferedReader commands = newBufferedReader(Paths.get("commands.txt"), Charset.forName("ISO-8859-1"));
            while ((line = commands.readLine()) != null) {
                
                System.out.println(line);
                
                itemXlate.setCommandIn(line); itemXlate.translate();
                commandXlate.setCommandIn(line); commandXlate.translate();
                valueXlate.setCommandIn(line); valueXlate.translate();                                
                
                System.out.println("=> " + itemXlate.getCommandOut() + ", " + commandXlate.getCommandOut() + ", " + valueXlate.getCommandOut());
                System.out.println();

            }
        } catch (IOException e) {
            System.out.println("Error: cannot read file: " + e);
        }
    }

}
