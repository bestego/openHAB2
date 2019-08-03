/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author erik
 */
public class Index {

    private final String index;

    public Index(String index) {
        this.index = index;
    }

    /**
     * Extracts index or indices from line containing resprectively [i] or [i,j]
     *
     * @return List{@literal <Integer>} containg i [and j]
     */
    public List<Integer> getIndices() {
        int openBracket = index.indexOf("[");
        int closeBracket = index.indexOf("]");
        if ( openBracket == -1 | closeBracket == -1 ){
            throw new IllegalArgumentException("missing [ and/or ]");
        }
        List<String> slist = Arrays.asList(index.substring(index.indexOf("[") + 1, index.indexOf("]")).split(",")); // get content between [ and ]
        return slist.stream().map(i -> Integer.valueOf(i)).collect(Collectors.toList());    //convert String to Integer List
    }
}
