package com.wind.data;

import com.wind.DataSourceContextHolder;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSource {

    String value() default DataSourceContextHolder.DATA_SOURCE_A;

}
