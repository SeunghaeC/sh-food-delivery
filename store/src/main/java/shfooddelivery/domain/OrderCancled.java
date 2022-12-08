package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
}


