package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CouponSended extends AbstractEvent {

    private Long id;
    private String customerId;
    private String storeId;
    private String discountAmt;
}


