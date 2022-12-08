package shfooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class SendedCoupon {

    private Long id;
    private String customerId;
    private String storeId;
    private String isUsed;
    private Double discountAmt;
}


