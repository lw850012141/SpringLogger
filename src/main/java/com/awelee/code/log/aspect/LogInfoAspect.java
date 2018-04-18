package com.awelee.code.log.aspect;

import com.awelee.code.log.util.LogUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.awelee.code.log.service.LogInfoService;

@Aspect
@Component
public class LogInfoAspect {
	
	public final static Logger logger = LoggerFactory.getLogger(LogInfoAspect.class);

	@Autowired
	private LogInfoService logInfoService;

	//切点
	@Pointcut("@annotation(com.awelee.code.log.aspect.LogInfo)")
	public void logAspect() {

	}

	@Before(value = "logAspect()")
	public void before(JoinPoint joinPoint) {
		System.out.println("[Aspect1] before advise");
	}

	@Around(value = "logAspect()")
	public void around(ProceedingJoinPoint pjp) throws  Throwable{
		System.out.println("[Aspect1] around advise 1");
		pjp.proceed();
		System.out.println("[Aspect1] around advise2");
	}

	@AfterReturning(value = "logAspect()")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("[Aspect1] afterReturning advise");
	}

	@AfterThrowing(value = "logAspect()")
	public void afterThrowing(JoinPoint joinPoint) {
		System.out.println("[Aspect1] afterThrowing advise");
	}

	@After(value = "logAspect()")
	public void after(JoinPoint joinPoint) {
		System.out.println("[Aspect1] after advise");
		try {
			logInfoService.insertLog(LogUtils.returnLog(joinPoint));
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}