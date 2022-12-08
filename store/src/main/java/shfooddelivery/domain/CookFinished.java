package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String address;
    private String storeAddress;

    public CookFinished(AcceptedOrder aggregate){
        super(aggregate);
    }
    public CookFinished(){
        super();
    }
}
