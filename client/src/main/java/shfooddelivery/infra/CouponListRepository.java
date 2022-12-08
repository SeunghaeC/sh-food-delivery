package shfooddelivery.infra;

import shfooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="couponLists", path="couponLists")
public interface CouponListRepository extends PagingAndSortingRepository<CouponList, Long> {

    

    
}
