package com.service;

import com.entites.UserData;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient("user-server")
public interface UserClient {

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    UserData saveUser(@RequestBody UserData user);


    @RequestMapping(value = "/users/{id}/{userChannel}",method = RequestMethod.DELETE)
    int removeUserById(@PathVariable("id") long id, @PathVariable("userChannel") int userChannel);


    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    int updateUser(@RequestBody UserData user);




    @RequestMapping(value = "/users/{id}/{userChannel}",method = RequestMethod.GET)
    UserData getUserById(@PathVariable("id") long id, @PathVariable("userChannel") int userChannel);



//    @RequestMapping(value = "/users/query",method = RequestMethod.POST)
//    UserCollection listUserByCondition(@RequestBody UserCondition userCondition);

    @RequestMapping(value = "/users/{userChannel}",method = RequestMethod.GET)
    List<UserData> listUserAll(@PathVariable("userChannel") int userChannel);

    @RequestMapping(value = "/users/openId/{openId}/{userChannel}",method = RequestMethod.GET)
    UserData getUserByOpenId(@PathVariable("openId") String openId, @PathVariable("userChannel") int userChannel);

    @RequestMapping(value = "/users/inviteCount/{id}",method = RequestMethod.GET)
    int getInviteCount(@PathVariable("id") long id);

    @RequestMapping(value = "/users/address/{id}/{userChannel}/{address}",method = RequestMethod.GET)
    int updateAddress(@PathVariable("id") long id, @PathVariable("userChannel") int userChannel, @PathVariable("address") String address);

}
