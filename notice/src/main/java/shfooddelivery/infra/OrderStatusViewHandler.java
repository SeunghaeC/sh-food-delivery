package shfooddelivery.infra;

import shfooddelivery.domain.*;
import shfooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusViewHandler {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderStatus orderStatus = new OrderStatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderStatus.setId(orderPlaced.getId());
            orderStatus.setCustomerId(orderPlaced.getCustomerId());
            orderStatus.setStatus("ordered");
            // view 레파지 토리에 save
            orderStatusRepository.save(orderStatus);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(paid.getId());

            if( orderStatusOptional.isPresent()) {
                 OrderStatus orderStatus = orderStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("paid");    
                // view 레파지 토리에 save
                 orderStatusRepository.save(orderStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_2(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(Long.valueOf(orderAccepted.getOrdered()));

            if( orderStatusOptional.isPresent()) {
                 OrderStatus orderStatus = orderStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("orderAccepted");    
                // view 레파지 토리에 save
                 orderStatusRepository.save(orderStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancled_then_UPDATE_3(@Payload OrderCancled orderCancled) {
        try {
            if (!orderCancled.validate()) return;
                // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(orderCancled.getId());

            if( orderStatusOptional.isPresent()) {
                 OrderStatus orderStatus = orderStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("cancled");    
                // view 레파지 토리에 save
                 orderStatusRepository.save(orderStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_4(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(Long.valueOf(orderRejected.getOrderId()));

            if( orderStatusOptional.isPresent()) {
                 OrderStatus orderStatus = orderStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("orderRejected");    
                // view 레파지 토리에 save
                 orderStatusRepository.save(orderStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_5(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(Long.valueOf(cookStarted.getOrderId()));

            if( orderStatusOptional.isPresent()) {
                 OrderStatus orderStatus = orderStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("cookStarted");    
                // view 레파지 토리에 save
                 orderStatusRepository.save(orderStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_6(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(Long.valueOf(picked.getOrderId()));

            if( orderStatusOptional.isPresent()) {
                 OrderStatus orderStatus = orderStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("pidcked");    
                // view 레파지 토리에 save
                 orderStatusRepository.save(orderStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompeleted_then_UPDATE_7(@Payload DeliveryCompeleted deliveryCompeleted) {
        try {
            if (!deliveryCompeleted.validate()) return;
                // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(Long.valueOf(deliveryCompeleted.getId()));

            if( orderStatusOptional.isPresent()) {
                 OrderStatus orderStatus = orderStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("success");    
                // view 레파지 토리에 save
                 orderStatusRepository.save(orderStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

