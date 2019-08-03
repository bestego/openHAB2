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
public class Translation {

    String translation;

    Translation(String translation) {
        this.translation = translation;
    }
    
    @Override
    public String toString(){
        return translation;
    }
}
