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
    @Autowired SendedCouponRepository sendedCouponRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_UpdateUsedCoupon(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener UpdateUsedCoupon : " + paid + "\n\n");


        

        // Sample Logic //
        SendedCoupon.updateUsedCoupon(event);
        

        

    }

}


