package shfooddelivery.domain;

import shfooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String menuInfo;
    private String customerId;
}
