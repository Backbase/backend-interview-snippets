package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RetailCustomer extends AbstractCustomer {
    private static final int PROMOTION_PERIOD_IN_MONTHS = 24;

    @Override
    public int getPromotionIntervalInMonths() {
        return PROMOTION_PERIOD_IN_MONTHS;
    }
}
