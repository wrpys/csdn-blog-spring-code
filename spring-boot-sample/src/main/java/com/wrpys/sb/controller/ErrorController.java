package com.wrpys.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wrp
 * @Date 2017/9/25
 */
@RestController
public class ErrorController {

    @GetMapping("404")
    public String to404() {
        return "地址未找到！";
    }

    @GetMapping("500")
    public String to500() {
        return "服务出错！";
    }

}
