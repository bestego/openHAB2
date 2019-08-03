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
 *
 * @author erik
 */
public class Rules {

    private Map<Alias, Translation> map = new LinkedHashMap<>();    //LinkedHashMap to preserve order
    private int loadedLines;

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

    protected Translation put(Alias alias, Translation translation) {
        Translation rv = map.put(alias, translation);
        if (rv != null) {
            throw new IllegalArgumentException("Duplicate alias \"" + alias + "\"");
        }
        return map.put(alias, translation);    // ToDo: handle & test duplicate Aliases
    }

    public Translation get(Alias alias) {
        return map.get(alias);
    }

    public Set<Alias> getAliases() {
        return map.keySet();
    }

    public void loadFile(Path file) throws IOException {
        loadLines(Files.lines(file));
    }

    public int loadLines(Stream<String> lines) {    // ToDo: test correct addition to Map
        loadedLines = 0;
        lines.forEach(l -> {
            add(l);
            loadedLines++;
        });
        return loadedLines;
    }

    private List<Rule> validate(String line) {
        // skip comment lines
        // skip blank lines
        // skip empty lines
        if (!line.matches(".+:.+")) {
            throw new IllegalArgumentException("missing colon in line " + line);
        }
        String[] fields = line.split(":");
        String translation = fields[0].trim();
        String[] aliases = fields[1].split(",");

        List<Rule> ruleList = new ArrayList<>();
        for (String s : aliases) {
            ruleList.add(new Rule(new Alias(s), new Translation(translation)));
        }
        return ruleList;
    }
}
