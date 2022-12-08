package shfooddelivery.domain;

import shfooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="sendedCoupons", path="sendedCoupons")
public interface SendedCouponRepository extends PagingAndSortingRepository<SendedCoupon, Long>{

}
