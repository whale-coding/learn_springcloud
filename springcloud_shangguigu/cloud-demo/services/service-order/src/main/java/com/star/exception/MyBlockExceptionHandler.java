package com.star.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.common.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * @Classname: MyBlockExceptionHandler
 * @Date: 2025/4/3 21:50
 * @Author: 聂建强
 * @Description: 自定义sentinel的 SpringMVC Web接口的异常处理
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    // 用于处理json
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String resourceName, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=utf-8");

        PrintWriter writer = httpServletResponse.getWriter();

        R error = R.error(500,resourceName + "被Sentinel限制了，原因: " + e.getClass());

        String json = objectMapper.writeValueAsString(error);  // 转为json

        writer.write(json);  // 写出去

        writer.flush();
        writer.close();
    }
}
