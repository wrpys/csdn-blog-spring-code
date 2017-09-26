package com.wrpys.sb.common;

import com.wrpys.sb.exception.MyCheckedException;
import com.wrpys.sb.exception.MyUnCheckedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wrp
 * @Date 2017/9/26
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("GlobalExceptionHandler===defaultErrorHandler:", e);
        String msg = "";
        if (e instanceof MyCheckedException) {
            MyCheckedException mye = (MyCheckedException) e;
            // 返回数据构造
            msg = mye.getMsg();
        } else if (e instanceof MyUnCheckedException) {
            MyUnCheckedException mye = (MyUnCheckedException) e;
            // 返回数据构造
            msg = mye.getMsg();
        } else {
            // 返回数据构造
            msg = e.getMessage();
        }
        return ResponseEntity.ok(msg);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ModelAndView Handler(HttpServletRequest req, Exception e) throws Exception {
        log.error("GlobalExceptionHandler===", e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorInfo", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("redirect:/500");
        return mav;
    }

}
