package org.mrstm.factory.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.VehicleType;

@Getter
@Setter
public class Bike extends Vehicle{
    public Bike(String numberPlate, VehicleType vehicleType) {
        super(numberPlate, vehicleType);
    }
}
