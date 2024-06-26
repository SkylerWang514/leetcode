package utils;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-03-06 22:22
 **/

import java.lang.annotation.*;

/**
 * 年龄校验
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface ValidateAge {
    /**
     * 最小值
     */
    int min() default 18;
    /**
     * 最大值
     */
    int max() default 99;
    /**
     * 默认值
     */
    int value() default 20;
}
