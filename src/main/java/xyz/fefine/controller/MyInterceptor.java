package xyz.fefine.controller;

import bid.fese.entity.SeRequest;
import bid.fese.entity.SeResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.fefine.entity.Interceptor;

import java.lang.reflect.Method;

/**
 * Created by feng_sh on 17-6-4.
 * 测试用拦截器
 */
public class MyInterceptor implements Interceptor {

    private static final Logger logger = LogManager.getLogger(MyInterceptor.class);

    @Override
    public void before(SeRequest request, SeResponse response, Method method, Object[] args) {
        logger.info("before request");
    }

    @Override
    public void after(SeRequest request, SeResponse response, Method method, Object[] args) {
        logger.info("after request");
    }

    @Override
    public void afterThrowing(SeRequest request, SeResponse response, Method method, Object[] args, Throwable throwable) {
        logger.info("after throwing");
    }

    @Override
    public void afterFinally(SeRequest request, SeResponse response, Method method, Object[] args) {
        logger.info("after finally");
    }
}
