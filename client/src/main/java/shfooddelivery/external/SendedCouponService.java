package shfooddelivery.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "coupon", url = "${api.url.coupon}")
public interface SendedCouponService {
    @RequestMapping(method= RequestMethod.GET, path="/sendedCoupons/{id}")
    public SendedCoupon getSendedCoupon(@PathVariable("id") Long id);
}
