/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.Bay;

/**
 *
 * @author s6089488
 */
public interface BayChainable
{
    public void addNext(BayChainable next);

    public Bay handle(Plane p);
}
