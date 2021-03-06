package com.lt.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 描述:用于注解一个controller的访问方法，如果被注解了@InnerOnly,则该接口只能在局域网内其他模块调用访问
 * 不能直接被用户请求。
 *
 * @author  boyce
 * @created 2015年5月17日 下午2:40:05
 * @since   v1.0.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InnerOnly {

}
