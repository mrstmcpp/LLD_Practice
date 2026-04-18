package org.mrstm.strategies.pricing;


import lombok.Builder;
import org.mrstm.enums.PricingType;

@Builder
public class PricingProcessor {
    public static PricingStrategy getPricingStrategy(PricingType pricingType){
        switch (pricingType){
            case TIME_BASED -> {
                return new TimeBased();
            }
            case EVENT_BASED -> {
                return new EventBased();
            }
        }

        return null;
    }
}
