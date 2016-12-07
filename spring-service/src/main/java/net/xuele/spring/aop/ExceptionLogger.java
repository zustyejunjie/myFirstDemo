package net.xuele.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 记录异常日志  通过aop实现，不用修改既有的业务代码
 * Created by yejunjie on 2016/12/7.
 */
public class ExceptionLogger {

    private Logger logger = LoggerFactory.getLogger(ExceptionLogger.class);

    private void log(Exception e){
        logger.error("切面异常日志记录：",e);
    }

}
