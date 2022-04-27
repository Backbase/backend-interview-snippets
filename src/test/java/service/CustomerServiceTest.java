package service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import dto.BusinessCustomer;
import enumeration.Tier;
import java.time.Instant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CustomerServiceTest {

    @Test
    public void businessCustomerSilver() {
        CustomerService customerService = Mockito.spy(new CustomerService());
        BusinessCustomer businessCustomer = Mockito.spy(new BusinessCustomer());
        doReturn(Instant.parse("2008-12-03T10:15:30.00Z")).when(customerService).getNextTierPromotionTime(any(BusinessCustomer.class));
        businessCustomer.setTier(Tier.SILVER);
        businessCustomer.setLastPromotion(Instant.parse("2007-12-03T10:15:30.00Z"));
        Mockito.when(businessCustomer.getPromotionIntervalInMonths()).thenReturn(2);
        Instant promotionTime = customerService.getNextTierPromotionTime(businessCustomer);
        Assertions.assertEquals(promotionTime, Instant.parse("2008-12-03T10:15:30.00Z"));
    }
}
