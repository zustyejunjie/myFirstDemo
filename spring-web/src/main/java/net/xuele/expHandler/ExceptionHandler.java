package net.xuele.expHandler;

import net.xuele.interceptor.LogRecorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yejunjie on 2016/8/30.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        logger.error("----------------统一异常处理----------------------");
        return null;
    }
}
