package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String orderId;
    private String menuInfo;
}


