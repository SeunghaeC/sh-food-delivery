package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryCompeleted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;

    public DeliveryCompeleted(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryCompeleted(){
        super();
    }
}
