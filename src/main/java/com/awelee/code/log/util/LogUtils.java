package com.awelee.code.log.util;

import com.awelee.code.log.aspect.LogInfo;
import com.awelee.code.log.enums.ModelEnum;
import com.awelee.code.log.enums.OperateTypeEnum;
import com.awelee.code.log.enums.SubModelEnum;
import com.awelee.code.log.po.Log;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

public class LogUtils {
	
	public static Log returnLog(JoinPoint joinPoint) throws ClassNotFoundException {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();

		ModelEnum model = ModelEnum.DEFAULT;
		SubModelEnum subModel = SubModelEnum.DEFAULT;
		OperateTypeEnum operationType = OperateTypeEnum.DEFAULT;
		String remark = "";

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					model =  method.getAnnotation(LogInfo.class).model();
					subModel = method.getAnnotation(LogInfo.class).subModel();
					operationType = method.getAnnotation(LogInfo.class).operateType();
					remark = method.getAnnotation(LogInfo.class).remark();
					break;
				}
			}
		}

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = ClientIpUtils.getIpAddr(request);

		Log log = new Log();

		log.setModel(model.getName());
		log.setSubModelName(subModel.getName());
		log.setOperateType(getOperateType(operationType));
		log.setRemark(remark);

		log.setUserId(1L);
		log.setUserName("Awelee");
		log.setDeptId(1L);
		log.setDeptNames("Awelee Of Group");
		log.setCompId(1L);
		log.setCompName("Awelee Of Company");
		log.setUrl(request.getRequestURL().toString());
		log.setClientIp(ip);
		log.setCreateTime(new Date());
		return log;
	}

	private static String getOperateType(OperateTypeEnum operationType){
		String operaType = OperateTypeEnum.DEFAULT.name();
		switch (operationType) {
			case ADD:
				operaType = "新增";
				break;
			case DELETE:
				operaType = "删除";
				break;
			case UPDATE:
				operaType = "修改";
				break;
			case QUERY:
				operaType = "查询";
				break;
			case UPLOADFILE:
				operaType = "上传文件";
				break;
			case DELETEFILE:
				operaType = "删除文件";
				break;
			case DOWNLOADFILE:
				operaType = "下载文件";
				break;
			default:
				break;
		}
		return operaType;
	}
}
