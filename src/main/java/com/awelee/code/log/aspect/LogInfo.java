package com.awelee.code.log.aspect;

import com.awelee.code.log.enums.ModelEnum;
import com.awelee.code.log.enums.SubModelEnum;
import com.awelee.code.log.enums.OperateTypeEnum;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogInfo {
	
	public abstract ModelEnum model() default ModelEnum.DEFAULT;

	public abstract SubModelEnum subModel() default SubModelEnum.DEFAULT;
	
	public abstract OperateTypeEnum operateType() default OperateTypeEnum.DEFAULT;
	
	public abstract String remark() default "";

}