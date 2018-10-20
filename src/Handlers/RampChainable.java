/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Enums.RampType;
import Enums.VehicleSize;

/**
 *
 * @author s6089488
 */
public interface RampChainable extends Chainable
{
    public void handle(VehicleSize size, RampType rampType);
}
