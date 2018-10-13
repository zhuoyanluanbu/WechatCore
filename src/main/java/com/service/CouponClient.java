package com.service;

import com.entites.Order;
import com.entites.SimpleResponseBody;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huyoucheng on 2018/10/12.
 */
@Component
@FeignClient("user-wxapp-access")
public interface CouponClient {

    @RequestMapping (value = "/api/inner/give/orders/{uid}")
    SimpleResponseBody<Order> giveCoupons(@PathVariable("uid") long uid);

}
