package org.mrstm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.VehicleType;

@AllArgsConstructor
@Getter
@Setter
public class ParkingSpot {
    private VehicleType vehicleType;
    private Ticket ticket;
}
