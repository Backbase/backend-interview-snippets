package dto;

import enumaration.Tier;
import java.time.Instant;
import lombok.Data;

@Data
public abstract class AbstractCustomer {
    protected String id;
    protected String name;
    protected Tier tier;
    protected Instant lastPromotion;

    public abstract int getPromotionIntervalInMonths();

}
