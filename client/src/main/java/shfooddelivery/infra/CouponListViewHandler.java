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
public class CouponListViewHandler {

    @Autowired
    private CouponListRepository couponListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCouponSended_then_CREATE_1 (@Payload CouponSended couponSended) {
        try {

            if (!couponSended.validate()) return;

            // view 객체 생성
            CouponList couponList = new CouponList();
            // view 객체에 이벤트의 Value 를 set 함
            couponList.setId(couponSended.getId());
            couponList.setCustomerId(couponSended.getCustomerId());
            couponList.setStoredId(couponSended.getStoreId());
            couponList.setDiscountAmt(couponSended.getDiscountAmt());
            couponList.setIsUsed("N");
            // view 레파지 토리에 save
            couponListRepository.save(couponList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<CouponList> couponListOptional = couponListRepository.findById(Long.valueOf(paid.getCouponId()));

            if( couponListOptional.isPresent()) {
                 CouponList couponList = couponListOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                couponList.setIsUsed("Y");    
                // view 레파지 토리에 save
                 couponListRepository.save(couponList);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

