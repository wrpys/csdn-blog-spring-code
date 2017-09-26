package com.wrpys.sb.controller;

import com.wrpys.sb.exception.MyCheckedException;
import com.wrpys.sb.exception.MyUnCheckedException;
import com.wrpys.sb.model.User;
import com.wrpys.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     *
     * @param params
     * @return
     */
    @PostMapping(value = "postSubmit")
    public Map<String, Object> postSubmit(@RequestBody Map<String, Object> params) {
        return params;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @PostMapping(value = "findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    /**
     * 500错误验证
     *
     * @return
     */
    @GetMapping(value = "error500")
    public Map<String, Object> error500() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0");
        int i = 10 / 0;
        return result;
    }

    /**
     * 业务异常统一处理 验证
     *
     * @return
     */
    @GetMapping(value = "exceptionTest/{exceptionType}")
    public Map<String, Object> exceptionTest(@PathVariable("exceptionType") Integer exceptionType) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0");

        if (exceptionType == 1) {
            throw new MyCheckedException("1", "自定义check异常", null);
        } else if (exceptionType == 2) {
            throw new MyUnCheckedException("1", "自定义uncheck异常", null);
        } else {
            int i = 10 / 0;
        }
        return result;
    }


}
