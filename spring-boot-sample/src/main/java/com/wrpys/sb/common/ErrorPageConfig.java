package com.wrpys.sb.common;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author wrp
 * @Date 2017/9/25
 */
@Configuration
public class ErrorPageConfig implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
        configurableEmbeddedServletContainer.addErrorPages(error404Page, error500Page);
    }

}
