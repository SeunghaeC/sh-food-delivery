package shfooddelivery.domain;

import shfooddelivery.domain.*;
import shfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private String costomerId;
    private String price;
    private String paymentStatus;
    private String couponId;
}


