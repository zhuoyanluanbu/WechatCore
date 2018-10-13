package com.service.outter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huyoucheng on 2018/10/11.
 */
@Component
@FeignClient(name = "baidu-server",url = "http://api.map.baidu.com")
public interface BaiduClient {
    @RequestMapping(value = "/geocoder/v2/")
    String getDetailAddressByLatLng(@RequestParam("callback") String callback,
                            @RequestParam("location") String location,
                            @RequestParam("output") String output,
                            @RequestParam("pois") int pois,
                            @RequestParam("ak") String ak);


}
