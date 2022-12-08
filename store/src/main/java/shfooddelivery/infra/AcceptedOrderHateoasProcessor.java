package shfooddelivery.infra;
import shfooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class AcceptedOrderHateoasProcessor implements RepresentationModelProcessor<EntityModel<AcceptedOrder>>  {

    @Override
    public EntityModel<AcceptedOrder> process(EntityModel<AcceptedOrder> model) {

        
        return model;
    }
    
}
