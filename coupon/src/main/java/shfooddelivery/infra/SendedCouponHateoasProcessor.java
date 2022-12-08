package shfooddelivery.infra;
import shfooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class SendedCouponHateoasProcessor implements RepresentationModelProcessor<EntityModel<SendedCoupon>>  {

    @Override
    public EntityModel<SendedCoupon> process(EntityModel<SendedCoupon> model) {

        
        return model;
    }
    
}
