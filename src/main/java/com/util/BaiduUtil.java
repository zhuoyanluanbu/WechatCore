package com.util;

import com.entites.DetailAddress;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.outter.BaiduClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by HYC on 2015/7/16.
 */
@Component
public class BaiduUtil {

    @Autowired
    BaiduClient baiduClient;

    //百度地图密钥(服务器端)
    private String coordinate_key = "22LfLLXCaDlN2VGiDbnHpiD9";//通过坐标解析具体地址的key
    private String ip_key = "ucybXTlDKC1o9cbAHrOzrEFa";//通过ip解析具体地址的key
    //百度地图地址逆解析接口 (基于坐标)
    public String coordinate_baiduMapApi="http://api.map.baidu.com/geocoder/v2/?ak="+coordinate_key+"&callback=renderReverse&location=latitude,longitude&output=json&pois=1";
    //百度地图地址逆解析接口 (基于ip)
    public String ip_baiduMapApi="http://api.map.baidu.com/location/ip?ak="+ip_key+"&ip=IP&coor=bd09ll";

    static ObjectMapper mapper = new ObjectMapper();

    public DetailAddress getDetailAddressByLatLng(double lat,double lng){
        double[] bdLatLng = PositionConvert.wgs2bd(lat,lng);
        String res = baiduClient.getDetailAddressByLatLng("renderReverse", bdLatLng[0] + "," + bdLatLng[1], "json", 1, coordinate_key);
        res = res.replace("renderReverse&&renderReverse(","").replace(")","");
        try {
            JsonNode node = mapper.readTree(res);
            JsonNode result = node.path("result");
            String formatted_address = result.path("formatted_address").asText();
            String province = result.path("addressComponent").path("province").asText();
            String city = result.path("addressComponent").path("city").asText();
            String district = result.path("addressComponent").path("district").asText();
            String street = result.path("addressComponent").path("street").asText();
            String street_number = result.path("addressComponent").path("street_number").asText();
            return new DetailAddress(formatted_address,district,province,city,street,street_number);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
