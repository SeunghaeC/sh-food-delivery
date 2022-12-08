package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String orderId;
    private String menuInfo;

    public OrderAccepted(AcceptedOrder aggregate){
        super(aggregate);
    }
    public OrderAccepted(){
        super();
    }
}
