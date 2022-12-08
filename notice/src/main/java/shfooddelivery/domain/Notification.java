package shfooddelivery.domain;

import shfooddelivery.NoticeApplication;
import javax.persistence.*;
import lombok.Data;


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

        repository().findById(orderAccepted.getId()).ifPresent(notification->{
            
            notification.notify();
            repository().save(notification);
         });
    }
    
    public static void kakaoNotify(OrderRejected orderRejected){


        repository().findById(orderRejected.getId()).ifPresent(notification->{
            
            notification.notify();
            repository().save(notification);
         });
    }
    
    public static void kakaoNotify(CookStarted cookStarted){

        repository().findById(cookStarted.getId()).ifPresent(notification->{
            
            notification.notify();
            repository().save(notification);
         });

        
    }
    
    public static void kakaoNotify(DeliveryCompeleted deliveryCompeleted){

        repository().findById(deliveryCompeleted.getId()).ifPresent(notification->{
            
            notification.notify();
            repository().save(notification);
         });
    }
    
    public static void kakaoNotify(Picked picked){

        repository().findById(picked.getId()).ifPresent(notification->{
            
            notification.notify();
            repository().save(notification);
         });
    }
    
    public static void kakaoNotify(CouponSended couponSended){

        
        repository().findById(couponSended.getId()).ifPresent(notification->{
            
            notification.notify();
            repository().save(notification);
         });        
    }

}
