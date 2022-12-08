package shfooddelivery.domain;

import shfooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Paid extends AbstractEvent {

    public Paid(Payment payment) {
    }

    private Long id;
    private String costomerId;
    private String price;
    private String paymentStatus;
    private String couponId;
}
