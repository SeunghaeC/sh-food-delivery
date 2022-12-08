package shfooddelivery.domain;

import shfooddelivery.domain.배달시작됨;
import shfooddelivery.domain.OrderAccepted;
import shfooddelivery.domain.OrderRejected;
import shfooddelivery.domain.CookStarted;
import shfooddelivery.domain.CookFinished;
import shfooddelivery.domain.쿠폰발행됨;
import shfooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="AcceptedOrder_table")
@Data

public class AcceptedOrder  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String menuInfo;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String storeAddress;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        배달시작됨 배달시작됨 = new 배달시작됨(this);
        배달시작됨.publishAfterCommit();



        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();



        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();



        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        쿠폰발행됨 쿠폰발행됨 = new 쿠폰발행됨(this);
        쿠폰발행됨.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static AcceptedOrderRepository repository(){
        AcceptedOrderRepository acceptedOrderRepository = StoreApplication.applicationContext.getBean(AcceptedOrderRepository.class);
        return acceptedOrderRepository;
    }




    public static void addOrder(Paid paid){

        /** Example 1:  new item 
        AcceptedOrder acceptedOrder = new AcceptedOrder();
        repository().save(acceptedOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(acceptedOrder->{
            
            acceptedOrder // do something
            repository().save(acceptedOrder);


         });
        */

        
    }
    public static void cancleOrder(OrderCancled orderCancled){

        /** Example 1:  new item 
        AcceptedOrder acceptedOrder = new AcceptedOrder();
        repository().save(acceptedOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancled.get???()).ifPresent(acceptedOrder->{
            
            acceptedOrder // do something
            repository().save(acceptedOrder);


         });
        */

        
    }


}
