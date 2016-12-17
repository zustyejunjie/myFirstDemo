package net.xuele.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by yejunjie on 2016/12/12.
 */
public class LogRecorder extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(LogRecorder.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;

    }


    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("[remoteAddress:" + request.getRemoteAddr() + "|requestUrl:" + request.getRequestURI() + "]");
        if (logger.isInfoEnabled()) {

            PrintWriter writer = response.getWriter();
            writer.print("ssssssssssssssssssssssssssss");
            if (true) {
//                throw new Exception("dd");
            }


            if (ex != null) {
            }
        }
    }
}
