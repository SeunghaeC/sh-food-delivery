package shfooddelivery.domain;

import shfooddelivery.domain.Picked;
import shfooddelivery.domain.DeliveryCompeleted;
import shfooddelivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String riderId;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){


        Picked picked = new Picked(this);
        picked.publishAfterCommit();



        DeliveryCompeleted deliveryCompeleted = new DeliveryCompeleted(this);
        deliveryCompeleted.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }






}
