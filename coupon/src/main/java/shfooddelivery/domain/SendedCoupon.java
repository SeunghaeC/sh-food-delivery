package shfooddelivery.domain;

import shfooddelivery.domain.CouponSended;
import shfooddelivery.CouponApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="SendedCoupon_table")
@Data

public class SendedCoupon  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String isUsed;
    
    
    
    
    
    private Double discountAmt;

    @PostPersist
    public void onPostPersist(){


        CouponSended couponSended = new CouponSended(this);
        couponSended.publishAfterCommit();

    }

    public static SendedCouponRepository repository(){
        SendedCouponRepository sendedCouponRepository = CouponApplication.applicationContext.getBean(SendedCouponRepository.class);
        return sendedCouponRepository;
    }




    public static void updateUsedCoupon(Paid paid){

        /** Example 1:  new item 
        SendedCoupon sendedCoupon = new SendedCoupon();
        repository().save(sendedCoupon);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(sendedCoupon->{
            
            sendedCoupon // do something
            repository().save(sendedCoupon);


         });
        */

        
    }


}
