package shfooddelivery.domain;

import shfooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderCancled extends AbstractEvent {

    private Long id;
}
