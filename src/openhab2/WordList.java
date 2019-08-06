/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Extends ArrayList and overloads indexOf method allowing to also use regex
 * instead of regular String
 *
 * @author erik
 */
public class WordList {

    private final ArrayList<String> wordList = new ArrayList<>();

    WordList(String line) {
        wordList.addAll(Arrays.asList(line.trim().split("[ \t]+")));
    }

    /**
     * Get first position in list of words that matches regex
     *
     * @param regex regular expression to find matching word
     * @return returns position (=index) of 1st word matching regex
     */
    public int indexOf(String regex) {
        //get pos of word in list matching 
        for (int p = 0; p < wordList.size(); p++) {
            if (wordList.get(p).matches(".*"+regex+".*")) {
                return p;
            }
        }
        return -1;
    }

    /**
     * Returns field matching position pos
     * @param pos position 
     * @return String matching field
     */
    public String get(int pos) {
        return wordList.get(pos);
    }

    /**
     * Returns number if fields in line
     * @return int number of fields 
     */
    public int size() {
        return wordList.size();
    }
}
