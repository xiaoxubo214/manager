package com.wind.data;

import com.wind.DataSourceContextHolder;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class DataSourceAspect implements MethodBeforeAdvice,
        AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method,
                               Object[] args, Object target) throws Throwable {
        DataSourceContextHolder.clearDbType();
    }

    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        if (method.isAnnotationPresent(DataSource.class)) {
            DataSource datasource = method.getAnnotation(DataSource.class);
            DataSourceContextHolder.setDbType(datasource.value());
        } else {
            DataSourceContextHolder
                    .setDbType(DataSourceContextHolder.DATA_SOURCE_A);
        }

    }
}

