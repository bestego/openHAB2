/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Represents collection of translation rules 
 *
 * @author erik
 */
public class Rules {

    /** Holds collection of rules */
    private Map<Alias, Translation> map = new LinkedHashMap<>();    //LinkedHashMap to preserve order

    /**
     * Adds a translation rule to collection
     * @param line
     * @throws IllegalArgumentException when illegal rule definition
     */
    public void add(String line) {

        //ReDo this part with sensible exception(s)
        if (line == null) {                                 // skip null lines
            return;
        }
        if (line.matches("[ \t]*")) {
            return;                                    // skip empty/blank lines
        }
        if (line.matches("[ \t]*[#!].*")) // skip comment lines        
        {
            return;
        }
        if (!line.matches(".+:.+")) {
            throw new IllegalArgumentException("Invalid rules definition \"" + line + "\"");
        }

        String[] fields = line.split(":");
        String translation = fields[0].trim();
        String[] aliases = fields[1].split(",");

        for (String s : aliases) {
            put(new Alias(s.trim().toLowerCase()), new Translation(translation));
        }
    }

    /**
     * Directly adds translation rule to collection
     * @param alias key
     * @param translation value
     * @exception IllegalArgumentException (unchecked) when duplicate alias
     */
    protected void put(Alias alias, Translation translation) {
        Translation rv = map.put(alias, translation);
        if (rv != null) {
            throw new IllegalArgumentException("Duplicate alias \"" + alias + "\"");
        }
    }

    /**
     * Returns matching translation, or null when no match found
     * @param alias key to be found
     * @return translation matching above key
     */
    public Translation get(Alias alias) {
        return map.get(alias);
    }

    /**
     * Returns set of aliases from collection of rules
     * @return Set{@literal <Alias>}
     */
    public Set<Alias> getAliases() {
        return map.keySet();
    }

    /**
     * Loads rule definitions from external file
     * @param file
     * @throws IOException 
     */
    public void loadFile(Path file) throws IOException {
        loadLines(Files.lines(file));
    }

    /** Loads rule as single line into collection 
     * @param lines line containing rule definition
     */
    public void loadLines(Stream<String> lines) {    // ToDo: test correct addition to Map
        lines.forEach(l -> {
            add(l);
        });
    }
}
