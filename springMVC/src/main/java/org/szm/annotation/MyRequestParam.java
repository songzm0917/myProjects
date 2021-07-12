package org.szm.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {

    /**
     * 表示参数的别人，必填
     * @return
     */
    String value();
}
