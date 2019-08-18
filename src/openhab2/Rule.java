/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

/**
 * Class representing translation pair Alias {@literal ->} Translation
 * @author erik
 */
public class Rule {
    /** holds search key */
    public Alias alias;
    /** holds matching value */
    public Translation translation;
    
    /**
     * Constructor
     * @param alias
     * @param translation 
     */
    Rule(Alias alias, Translation translation){
        this.alias = alias;
        this.translation = translation;
    }
}
