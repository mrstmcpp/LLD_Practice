package org.mrstm.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.VehicleType;

import java.util.Date;

@Getter
@Builder
@Setter
public class Ticket {
    private String id;
    private Date entryTime;
    private Date exitTime;
    private VehicleType vehicleType;
    private String numberPlate;
    private ParkingSpot parkingSpot;
    private int price;
}
