package shfooddelivery.domain;

import shfooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="acceptedOrders", path="acceptedOrders")
public interface AcceptedOrderRepository extends PagingAndSortingRepository<AcceptedOrder, Long>{

}
