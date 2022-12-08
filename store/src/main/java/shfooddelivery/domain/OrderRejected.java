package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String orderId;

    public OrderRejected(AcceptedOrder aggregate){
        super(aggregate);
    }
    public OrderRejected(){
        super();
    }
}
