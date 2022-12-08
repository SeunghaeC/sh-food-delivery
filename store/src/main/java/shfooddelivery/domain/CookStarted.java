package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderId;

    public CookStarted(AcceptedOrder aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
