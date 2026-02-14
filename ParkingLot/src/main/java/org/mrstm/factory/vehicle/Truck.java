package org.mrstm.factory.vehicle;

import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.VehicleType;

@Getter
@Setter
public class Truck extends Vehicle{
    public Truck(String numberPlate, VehicleType vehicleType) {
        super(numberPlate, vehicleType);
    }
}
