package shfooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="CouponList_table")
@Data
public class CouponList {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String customerId;
        private String storedId;
        private String isUsed;
        private String discountAmt;


}
