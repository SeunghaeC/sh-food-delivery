package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String address;
    private String storeAddress;
}


