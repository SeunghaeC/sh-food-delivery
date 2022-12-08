package shfooddelivery.infra;

import javax.transaction.Transactional;

import shfooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shfooddelivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired AcceptedOrderRepository acceptedOrderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_AddOrder(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener AddOrder : " + paid + "\n\n");


        

        // Sample Logic //
        AcceptedOrder.addOrder(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancled'")
    public void wheneverOrderCancled_CancleOrder(@Payload OrderCancled orderCancled){

        OrderCancled event = orderCancled;
        System.out.println("\n\n##### listener CancleOrder : " + orderCancled + "\n\n");


        

        // Sample Logic //
        AcceptedOrder.cancleOrder(event);
        

        

    }

}


