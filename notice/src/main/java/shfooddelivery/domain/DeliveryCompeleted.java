package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryCompeleted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
}


