package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessCustomer extends AbstractCustomer {
    private static final int PROMOTION_PERIOD_IN_MONTHS = 12;

    private String organizationName;

    @Override
    public int getPromotionIntervalInMonths() {
        return PROMOTION_PERIOD_IN_MONTHS;
    }
}
