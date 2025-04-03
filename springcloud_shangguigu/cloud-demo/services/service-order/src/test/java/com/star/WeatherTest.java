package com.star;

import com.star.feign.WeatherFeignClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname: WeatherTest
 * @Date: 2025/4/3 17:07
 * @Author: 聂建强
 * @Description: 测试feign远程调用第三方API，查询天气信息
 */
@SpringBootTest
public class WeatherTest {
    @Resource
    private WeatherFeignClient weatherFeignClient;
    @Test
    public void test01(){
        String weather = weatherFeignClient.getWeather("APPCODE 93b7e19861a24c519a7548b17dc16d75",
                "50b53ff8dd7d9fa320d3d3ca32cf8ed1",
                "2182");

        System.out.println("weather = " + weather);

    }
}
