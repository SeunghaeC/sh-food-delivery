package shfooddelivery.domain;

import shfooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class CouponSended extends AbstractEvent {

    private Long id;
    private String customerId;
    private String storeId;
    private String discountAmt;
}
