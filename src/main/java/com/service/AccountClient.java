package com.service;


import com.entites.AccountData;
import com.entites.SystemGiveForm;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: ZHJJ
 * Date: 2018/8/9
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
@FeignClient("account-server")
public interface AccountClient {

    @RequestMapping(value = "/account/user-get",method = RequestMethod.GET)
    AccountData getAccountByUserId(@RequestParam("userId") long userId);

    //系统赠送
    @RequestMapping(value = "/account/system-give",method = RequestMethod.POST)
    AccountData systemGive(SystemGiveForm systemGiveForm);

}
