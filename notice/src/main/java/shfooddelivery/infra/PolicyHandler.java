package shfooddelivery.infra;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import shfooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shfooddelivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationRepository notificationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderAccepted'")
    public void wheneverOrderAccepted_KakaoNotify(@Payload OrderAccepted orderAccepted){

        OrderAccepted event = orderAccepted;
        System.out.println("\n\n##### listener KakaoNotify : " + orderAccepted + "\n\n");


        

        // Sample Logic //
        Notification.kakaoNotify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_KakaoNotify(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener KakaoNotify : " + orderRejected + "\n\n");


        

        // Sample Logic //
        Notification.kakaoNotify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookStarted'")
    public void wheneverCookStarted_KakaoNotify(@Payload CookStarted cookStarted){

        CookStarted event = cookStarted;
        System.out.println("\n\n##### listener KakaoNotify : " + cookStarted + "\n\n");


        

        // Sample Logic //
        Notification.kakaoNotify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCompeleted'")
    public void wheneverDeliveryCompeleted_KakaoNotify(@Payload DeliveryCompeleted deliveryCompeleted){

        DeliveryCompeleted event = deliveryCompeleted;
        System.out.println("\n\n##### listener KakaoNotify : " + deliveryCompeleted + "\n\n");


        

        // Sample Logic //
        Notification.kakaoNotify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Picked'")
    public void wheneverPicked_KakaoNotify(@Payload Picked picked){

        Picked event = picked;
        System.out.println("\n\n##### listener KakaoNotify : " + picked + "\n\n");


        

        // Sample Logic //
        Notification.kakaoNotify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponSended'")
    public void wheneverCouponSended_KakaoNotify(@Payload CouponSended couponSended){

        CouponSended event = couponSended;
        System.out.println("\n\n##### listener KakaoNotify : " + couponSended + "\n\n");


        

        // Sample Logic //
        Notification.kakaoNotify(event);
        

        

    }

}


