package com.wrpys.sb.controller;

import com.wrpys.sb.model.User;
import com.wrpys.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wrp
 * @Date 2017/9/23
 */
@RestController
@RequestMapping("restful")
public class RestfulControllrt {

    @Autowired
    private UserService userService;

    /**
     * get方式请求
     *
     * @return
     */
    @GetMapping(value = "getJson")
    public Map<String, Object> getJson() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0");
        return result;
    }

    /**
     * post方式请求
     *
     * @return
     */
    @PostMapping(value = "postJson")
    public Map<String, Object> postJson() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0");
        return result;
    }

    /**
     * 提交json对象
     * @param params
     * @return
     */
    @PostMapping(value = "postSubmit")
    public Map<String, Object> postSubmit(@RequestBody Map<String, Object> params) {
        return params;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @PostMapping(value = "findAll")
    public List<User> findAll() {
        return userService.findAll();
    }


}
