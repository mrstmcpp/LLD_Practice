package org.mrstm.models;

import lombok.Builder;
import lombok.Getter;
import org.mrstm.enums.PaymentType;
import org.mrstm.enums.PricingType;
import org.mrstm.factory.vehicle.Vehicle;
import org.mrstm.strategy.payment.PaymentProcessor;
import org.mrstm.strategy.payment.PaymentStrategy;
import org.mrstm.strategy.pricing.PricingProcessor;
import org.mrstm.strategy.pricing.PricingStrategy;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class ParkingLot {
    private final String parkingLotName;
    private final int capacity;
    private final List<ParkingSpot> spots; // vehicle type wise spots
    public ConcurrentHashMap<String, ParkingSpot> vehicleToSpotMap = new ConcurrentHashMap<>(); // numberPlate, parkingSpot
    private final PricingType pricingType;
    private PricingStrategy pricingStrategy;

    public ParkingLot(String parkingLotName, int capacity, List<ParkingSpot> spots, PricingType pricingType) {
        this.parkingLotName = parkingLotName;
        this.capacity = capacity;
        this.spots = spots;
        this.pricingType = pricingType;
        this.pricingStrategy = PricingProcessor.getPricingStrategy(pricingType);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        System.out.println("Checking for empty spots. Please wait......");

        for (var spot : spots) {
            if (Objects.isNull(spot.getTicket()) && spot.getVehicleType().equals(vehicle.getVehicleType())) {
                System.out.println("Spot found... Generating Ticket... Please wait...");
                var ticket = Ticket.builder()
                        .id(UUID.randomUUID().toString())
                        .vehicleType(vehicle.getVehicleType())
                        .numberPlate(vehicle.getNumberPlate())
                        .entryTime(Date.from(Instant.now()))
                        .build();

                spot.setTicket(ticket);
                ticket.setParkingSpot(spot);

                vehicleToSpotMap.put(vehicle.getNumberPlate(), spot);

                System.out.println("Your ticket ID: " + ticket.getId());
                return ticket;
            }
        }
        System.out.println("No spots left for parking...");
        return null;
    }

    public void unparkVehicle(Ticket ticket, PaymentType paymentType) {

        System.out.println("Unparking your vehicle : " + ticket.getNumberPlate());
        var price = pricingStrategy.calculate(ticket);
        ticket.setPrice(price);
        System.out.println("Your price for ticket ID: " + ticket.getId() + " is: " + ticket
                .getPrice());
        System.out.println("Please pay: " + price);
        Objects.requireNonNull(PaymentProcessor.getPaymentMethod(paymentType)).pay(ticket);

        ticket.getParkingSpot().setTicket(null);
        vehicleToSpotMap.remove(ticket.getNumberPlate());
    }


}
