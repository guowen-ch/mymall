package com.gwen.mall.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * Description：valid 校验参数
 * Created By guowen
 */
public class ValidatorUtils {
    private static Validator validator;
    static{
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static void validateEntity(Object object,Class<?>... groups) throws Exception{
        Set<ConstraintViolation<Object>> constraintViolations;
        if(groups== null){
            constraintViolations = validator.validate(object);
        }else{
            constraintViolations = validator.validate(object,groups);
        }
        if(!constraintViolations.isEmpty()){
            Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator();
            StringBuilder sb =  new StringBuilder();
            while (iterator.hasNext()){
                ConstraintViolation constraintViolation = iterator.next();
                if(sb.length() > 0){
                    sb.append(",");
                }
                sb.append(constraintViolation.getMessage());
            }
            throw new Exception(sb.toString());
        }
    }
}
