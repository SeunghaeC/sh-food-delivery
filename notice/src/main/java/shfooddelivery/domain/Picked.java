package shfooddelivery.domain;

import shfooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Picked extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
}
