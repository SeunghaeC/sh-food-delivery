package shfooddelivery.domain;

import shfooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String orderId;
}
