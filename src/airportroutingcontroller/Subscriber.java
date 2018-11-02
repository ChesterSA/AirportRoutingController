/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

/**
 * Subscriber interface for bays to work with observer pattern
 * 
 * @author Chester Swann-Auger
 * @since 01/11/18
 */
public interface Subscriber
{
    /**
     * Any subscriber will implement this to react to the subject updating
     */
    public void update();
}
