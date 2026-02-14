package org.mrstm;

import org.mrstm.enums.PaymentType;
import org.mrstm.enums.PricingType;
import org.mrstm.enums.VehicleType;
import org.mrstm.factory.vehicle.Bike;
import org.mrstm.factory.vehicle.Car;
import org.mrstm.factory.vehicle.VehicleFactory;
import org.mrstm.models.ParkingLot;
import org.mrstm.models.ParkingSpot;
import org.mrstm.models.Ticket;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingSpot ps1 = new ParkingSpot(VehicleType.BIKE , null);
        ParkingSpot ps2 = new ParkingSpot(VehicleType.CAR , null);
        ParkingSpot ps3 = new ParkingSpot(VehicleType.CAR , null);
        ParkingSpot ps4 = new ParkingSpot(VehicleType.TRUCK , null);

        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        parkingSpotList.add(ps1);
        parkingSpotList.add(ps2);
        parkingSpotList.add(ps3);
        parkingSpotList.add(ps4);

        ParkingLot parkingLot1 = new ParkingLot("PL1" , 4, parkingSpotList , PricingType.TIME_BASED);
        System.out.println("Welcome to parking lot: " + parkingLot1.getParkingLotName());

        Car car1 = (Car) VehicleFactory.get("UP54AB1234" , VehicleType.CAR);
        Bike bike1 = (Bike) VehicleFactory.get("UP54AB1235" , VehicleType.BIKE);
        Bike bike2 = (Bike) VehicleFactory.get("UP54AB1236" , VehicleType.BIKE);



        System.out.println("Parking All....");

        Ticket car1Ticket = parkingLot1.parkVehicle(car1);
        Ticket bike1Ticket = parkingLot1.parkVehicle(bike1);
        Ticket bike2Ticket = parkingLot1.parkVehicle(bike2);
        car1Ticket.setEntryTime(Date.from(Instant.now().minus(3, ChronoUnit.HOURS)));


        System.out.println("Unparking....");
        parkingLot1.unparkVehicle(car1Ticket, PaymentType.UPI);
        parkingLot1.unparkVehicle(bike1Ticket , PaymentType.CARD);
    }
}