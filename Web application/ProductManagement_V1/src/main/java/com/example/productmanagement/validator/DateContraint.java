package com.example.productmanagement.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateContraint {
    String message() default "Ngày tạo phải cách hiện tại 3 tháng";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
