package service;

import dto.AbstractCustomer;
import exception.NotPromotableTierException;
import java.time.Instant;
import java.time.Period;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    /**
     * Calculates the next tier promotion time for a given customer.
     *
     * The final period is calculated as (base period per customer type) x (tier factor) months
     *
     * @param customer customer whose next tier promotion is to be calculated
     * @return promotion time for the next tier
     */
    public <T extends AbstractCustomer> Instant getNextTierPromotionTime(T customer) {
        if (!customer.getTier().isPromotable()) {
            throw new NotPromotableTierException();
        }

        var basePromotionInMonths = customer.getPromotionIntervalInMonths();
        var promotionInMonths = (int)(basePromotionInMonths * customer.getTier().getPromotionFactor());
        var promotesEvery = Period.ofMonths(promotionInMonths);
        return customer.getLastPromotion().plus(promotesEvery);
    }
}
