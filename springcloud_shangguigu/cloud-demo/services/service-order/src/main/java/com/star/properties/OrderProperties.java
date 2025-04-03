package com.star.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname: OrderProperties
 * @Date: 2025/4/3 14:55
 * @Author: 聂建强
 * @Description: 批量绑定属性，推荐这种做法
 */
@Component
@ConfigurationProperties(prefix = "order")  // 配置批量绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
@Data
public class OrderProperties {
    // 字段名需要与配置中的字段名保持一致
    String timeout;
    String autoConfirm;
}
