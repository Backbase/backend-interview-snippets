package dto;

import java.time.Instant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RetailCustomer extends Customer {
    private String id;
    private String name;
    private String tier;
    private Instant lastPromotion;
}
