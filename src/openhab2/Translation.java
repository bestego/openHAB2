/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

/**
 * Represents Translation type as part of translation Rule
 * @author erik
 */
public class Translation {

    String translation;

    /**
     * Constructor sets translation
     * @param translation 
     */
    Translation(String translation) {
        this.translation = translation;
    }
    
    /**
     * Returns String representation of Translation object
     * @return transaltion
     */
    @Override
    public String toString(){
        return translation;
    }
}
