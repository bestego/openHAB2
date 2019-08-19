/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

/**
 * Type definition holding string to be matched with (parts of) command line
 * @author erik van Gompel
 */
public class Alias {

    /** Holds search string in lower case */
    String alias;

    Alias(String alias) {
        this.alias = alias.trim().toLowerCase();
    }

    /**
     * Tests equality between to Alias objects
     * @param obj other Alias object to compare with
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null && !(obj instanceof Alias)) {
            return false;
        }
        return alias.equals(((Alias) obj).alias);
    }

    /**
     * Calculates hashCode()
     * @return int
     */
    @Override
    public int hashCode() {
        return alias.hashCode();
    }

    /**
     * Returns String representing of Alias object 
     * @return String 
     */
    @Override
    public String toString() {
        return alias;
    }

}
