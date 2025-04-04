package com.star.predicate;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Classname: VipRoutePredicateFactory
 * @Date: 2025/4/4 13:04
 * @Author: 聂建强
 * @Description: 自定义断言工厂
 * VipRoutePredicateFactory，前缀Vip要与yml中配置的断言工厂一致，即Vip
 * RoutePredicateFactory是固定后缀
 */
@Component
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {

    // 空参构造器
    public VipRoutePredicateFactory() {
        super(Config.class);
    }

    // 自己的断言判断逻辑规则
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                // localhost/search?q=haha&user=leifengyang
                ServerHttpRequest request = serverWebExchange.getRequest();  // 拿到请求

                String first = request.getQueryParams().getFirst(config.param);  // 获取请求参数

                return StringUtils.hasText(first) && first.equals(config.value);
            }
        };
    }

    // 短格式的属性顺序
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param", "value");
    }

    /**
     * 可以配置的参数
     */
    @Validated
    public static class Config {

        @NotEmpty
        private String param;


        @NotEmpty
        private String value;

        public @NotEmpty String getParam() {
            return param;
        }

        public void setParam(@NotEmpty String param) {
            this.param = param;
        }

        public @NotEmpty String getValue() {
            return value;
        }

        public void setValue(@NotEmpty String value) {
            this.value = value;
        }
    }
}
