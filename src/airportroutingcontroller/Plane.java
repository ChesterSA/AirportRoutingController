/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Enums.VehicleSize;

/**
 *
 * @author s6089488
 */
public class Plane {

    public final int maxFood;
    public int foodQuantity;
    public VehicleSize size;

    public Plane(int maxFood, int foodQuantity, VehicleSize size) {
        this.maxFood = maxFood;
        this.foodQuantity = foodQuantity;
        this.size = size;
    }
    
    
}
