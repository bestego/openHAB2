/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.util.List;

/**
 * 
 * @author erik
 */
public class Translator {

    private String commandIn;
    private String commandOut;
    private Rules rules;
    private final String SPACE = " ";

    public Translator() {
    }

    public Translator(Rules rules) {
        this.rules = rules;
    }

    public String getCommandIn() {
        return commandIn.trim();
    }

    public void setCommandIn(String command) {
        commandIn = command;
    }

    public String getCommandOut() {
        if (commandOut == null && commandIn != null ) {
            translate(commandIn);
        }
        return commandOut;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    final public String translate(String command) {

        commandIn = command;
        command = SPACE + command.replaceAll("%"," % ") + SPACE;
        String regex;
        String lastAlias = null;
        commandOut = null;
        for (Alias al : rules.getAliases()) {
            regex = ".*" + al + ".*";
            if ( command.toLowerCase().matches(regex)) {
                lastAlias = al.toString();
                commandOut = rules.get(al).toString();
            }
        }

        if (commandOut != null && (commandOut.matches("\\[[+-]?[0-9]\\]") | commandOut.matches("\\[[-+]?[0-9]+,[-+]?[0-9]\\]"))) {

            Index offset = new Index(commandOut);
            List<Integer> index = offset.getIndices();
            int startOffset = index.get(0);
            int endOffset = startOffset;
            if (index.size() == 2) {
                endOffset = index.get(1);
            }

            WordList fields = new WordList(command);
            int currPos = fields.indexOf(lastAlias);

            int startIndex = currPos + startOffset;
            int endIndex = currPos + endOffset;

            if ( startIndex > endIndex ) {
                throw new IllegalArgumentException(commandOut + ":" + lastAlias);
            }
            
            if (startIndex < 0 | fields.size() <= endIndex) {
                throw new IndexOutOfBoundsException(commandOut + ":" + lastAlias + " >" + command.trim() + "<");
            }

            StringBuilder buf = new StringBuilder();
            for (int i = startIndex; i <= endIndex; i++) {
                buf.append(fields.get(i));
                buf.append(SPACE);
            }
            commandOut = buf.toString().trim();

        }
        return commandOut;
    }
}
