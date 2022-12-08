package shfooddelivery.domain;

import shfooddelivery.NoticeApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Notification_table")
@Data

public class Notification  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String message;


    public static NotificationRepository repository(){
        NotificationRepository notificationRepository = NoticeApplication.applicationContext.getBean(NotificationRepository.class);
        return notificationRepository;
    }




    public static void kakaoNotify(OrderAccepted orderAccepted){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void kakaoNotify(OrderRejected orderRejected){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void kakaoNotify(CookStarted cookStarted){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void kakaoNotify(DeliveryCompeleted deliveryCompeleted){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompeleted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void kakaoNotify(Picked picked){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(picked.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void kakaoNotify(CouponSended couponSended){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponSended.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }


}
