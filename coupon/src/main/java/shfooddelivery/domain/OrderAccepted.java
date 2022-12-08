package shfooddelivery.domain;

import shfooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String orderId;
    private String menuInfo;
}
