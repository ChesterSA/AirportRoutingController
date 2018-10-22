/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public interface Chainable
{
    public void addNext(Chainable next);
    
    public boolean handle(Plane p);
}
