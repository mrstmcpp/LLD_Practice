package org.mrstm.factory.vehicle;

import org.mrstm.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle get(String numberPlate , VehicleType vehicleType){
        switch (vehicleType){
            case CAR -> {
                return new Car(numberPlate, VehicleType.CAR);
            }
            case BIKE -> {
                return new Bike(numberPlate, VehicleType.BIKE);
            }
            case TRUCK -> {
                return new Truck(numberPlate, VehicleType.TRUCK);
            }
        }
        return null;
    };
}
