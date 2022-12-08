package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CouponSended extends AbstractEvent {

    private Long id;
    private String customerId;
    private String storeId;
    private String discountAmt;

    public CouponSended(SendedCoupon aggregate){
        super(aggregate);
    }
    public CouponSended(){
        super();
    }
}
