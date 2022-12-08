package shfooddelivery.infra;

import javax.naming.NameParser;

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
    @Autowired 주문Repository 주문Repository;
    @Autowired OrderRepository orderRepository;
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='배달시작됨'")
    public void whenever배달시작됨_주문상태변경(@Payload 배달시작됨 배달시작됨){

        배달시작됨 event = 배달시작됨;
        System.out.println("\n\n##### listener 주문상태변경 : " + 배달시작됨 + "\n\n");


        

        // Sample Logic //

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Picked'")
    public void wheneverPicked_UpdateOrderStatus(@Payload Picked picked){

        Picked event = picked;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + picked + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCompeleted'")
    public void wheneverDeliveryCompeleted_UpdateOrderStatus(@Payload DeliveryCompeleted deliveryCompeleted){

        DeliveryCompeleted event = deliveryCompeleted;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + deliveryCompeleted + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderAccepted'")
    public void wheneverOrderAccepted_UpdateOrderStatus(@Payload OrderAccepted orderAccepted){

        OrderAccepted event = orderAccepted;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + orderAccepted + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_UpdateOrderStatus(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + orderRejected + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookStarted'")
    public void wheneverCookStarted_UpdateOrderStatus(@Payload CookStarted cookStarted){

        CookStarted event = cookStarted;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + cookStarted + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookFinished'")
    public void wheneverCookFinished_UpdateOrderStatus(@Payload CookFinished cookFinished){

        CookFinished event = cookFinished;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + cookFinished + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }


    @Autowired
    shfooddelivery.external.SendedCouponService sendedCouponService;

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_Pay(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener Pay : " + orderPlaced + "\n\n");

        // REST Request Sample
        
        // sendedCouponService.getSendedCoupon(/** mapping value needed */);


        

        // Sample Logic //
        Order.pay(event);
        
        Payment.pay(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancled'")
    public void wheneverOrderCancled_CanclePayment(@Payload OrderCancled orderCancled){

        OrderCancled event = orderCancled;
        System.out.println("\n\n##### listener CanclePayment : " + orderCancled + "\n\n");


        

        // Sample Logic //
        Payment.canclePayment(event);
        

        

    }

}


