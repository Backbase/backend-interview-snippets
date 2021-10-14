package service;

import dto.BusinessCustomer;
import dto.Customer;
import dto.RetailCustomer;
import java.time.Instant;
import java.time.Period;
import java.util.List;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerService {

    private static final List<String> tiers = List.of(
        "BASIC", "SILVER", "GOLD", "PLATINUM", "DIAMOND", "EXCLUSIVE"
    );

    /**
     * Calculates the next tier promotion time for a given customer.
     *
     * Retails Customers, have a base period of 24 months;
     * Business Customers, have a base period of 12 months.
     *
     * Apart from the customer type, each tier has its own difficulty with a factor,
     * which affects the promotion period.
     *
     * The final period is calculated as (base period) x (tier factor) months
     *
     * @param customer customer whose next tier promotion is to be calculated
     * @return Next tier promotion time
     */
    public Instant getNextTierPromotion(Customer customer) {
        if (customer instanceof RetailCustomer) {
            var retailCustomer = ((RetailCustomer) customer);
            var basePromotionInMonths = 24;
            var promotionInMonths = (int)(basePromotionInMonths * getTierPromotionFactor(retailCustomer.getTier()));
            var promotesEvery = Period.ofMonths(promotionInMonths);
            return ((RetailCustomer) customer).getLastPromotion().plus(promotesEvery);
        } else if (customer instanceof BusinessCustomer) {
            var retailCustomer = ((RetailCustomer) customer);
            var basePromotionInMonths = 12;
            var promotionInMonths = (int)(basePromotionInMonths * getTierPromotionFactor(retailCustomer.getTier()));
            var promotesEvery = Period.ofMonths(promotionInMonths);
            return ((BusinessCustomer) customer).getLastPromotion().plus(promotesEvery);
        }

        throw new IllegalArgumentException("Customer type is not valid. (" + customer.getClass() + ")");
    }

    /**
     * Gets the promotion factor for a given tier.
     *
     * @param tier tier.
     * @return promotion factor for the given tier.
     */
    private double getTierPromotionFactor(String tier) {
        if ("BASIC".equals(tier)) {
            return 1;
        } else if ("SILVER".equals(tier)) {
            return 1.4;
        } else if ("GOLD".equals(tier)) {
            return 2;
        } else if ("PLATINUM".equals(tier)) {
            return 2.5;
        } else if ("DIAMOND".equals(tier)) {
            return 3.2;
        }

        throw new IllegalArgumentException("Tier value is not correct. Available tiers: " + tiers);
    }
}
