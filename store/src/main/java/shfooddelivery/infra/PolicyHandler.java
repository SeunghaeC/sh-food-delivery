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
    @Autowired 주문관리Repository 주문관리Repository;
    @Autowired AcceptedOrderRepository acceptedOrderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='결제승인됨'")
    public void whenever결제승인됨_주문정보받음(@Payload 결제승인됨 결제승인됨){

        결제승인됨 event = 결제승인됨;
        System.out.println("\n\n##### listener 주문정보받음 : " + 결제승인됨 + "\n\n");


        

        // Sample Logic //

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='결제취소됨'")
    public void whenever결제취소됨_주문취소처리(@Payload 결제취소됨 결제취소됨){

        결제취소됨 event = 결제취소됨;
        System.out.println("\n\n##### listener 주문취소처리 : " + 결제취소됨 + "\n\n");


        

        // Sample Logic //

        

    }

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


