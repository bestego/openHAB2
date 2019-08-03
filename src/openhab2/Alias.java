/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

/**
 *
 * @author erik
 */
public class Alias {

    String alias;

    Alias(String alias) {
        this.alias = alias.trim().toLowerCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null && !(obj instanceof Alias)) {
            return false;
        }
        return alias.equals(((Alias) obj).alias);
    }

    @Override
    public int hashCode() {
        return alias.hashCode();
    }

    @Override
    public String toString() {
        return alias;
    }

}
