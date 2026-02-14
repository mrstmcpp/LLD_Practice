package org.mrstm.strategy.pricing;

import org.mrstm.models.Ticket;

import java.time.Duration;
import java.time.Instant;

public class TimeBased implements PricingStrategy{
    @Override
    public int calculate(Ticket ticket) {
        var startTime = ticket.getEntryTime();
        var endTime = Instant.now();

        var timeDifference = Duration.between(startTime.toInstant() , endTime).toHours();

        int price = 100;
        while(timeDifference > 0){
            price += 50;
            timeDifference--;
        }
        return price;
    }
}
