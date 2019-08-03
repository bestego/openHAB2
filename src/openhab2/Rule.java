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
public class Rule {
    public Alias alias;
    public Translation translation;
    
    Rule(Alias alias, Translation translation){
        this.alias = alias;
        this.translation = translation;
    }
}
