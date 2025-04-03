package com.star.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname: WeatherFeignClient
 * @Date: 2025/4/3 17:02
 * @Author: 聂建强
 * @Description: 天气查询 OpenFeign客户端   远程调用第三方的API
 */
// 远程调用第三方API的时候，value = "xxx",可以随便写（不能省略不写），url写第三方的调用URL
@FeignClient(value = "weather-client", url = "http://aliv18.data.moji.com")
public interface WeatherFeignClient {
    /**
     * 查询天气，远程调用第三方的API
     * @param auth 请求头
     * @param token 凭证
     * @param cityId 城市id
     * @return 城市的天气信息
     */
    @PostMapping("/whapi/json/alicityweather/condition")
    String getWeather(@RequestHeader("Authorization") String auth,
                      @RequestParam("token") String token,
                      @RequestParam("cityId") String cityId);

}
