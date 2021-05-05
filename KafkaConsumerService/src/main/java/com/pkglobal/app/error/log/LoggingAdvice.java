package com.pkglobal.app.error.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pkglobal.app.model.ErrorLog;
import com.pkglobal.app.repository.ErrorLogRepository;

@Aspect
@Component
public class LoggingAdvice {

	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAdvice.class);

	@Autowired
	private ErrorLogRepository errorLogRepository;

	@AfterThrowing(pointcut = "execution(* com.pkglobal.app.consumer.*.*(..))", throwing = "e")
	public void logExceptionContext(JoinPoint joinPoint, Throwable e) {
		errorLogRepository
				.save(constructErrorLogObject(e.toString(), e.getMessage(), joinPoint.getArgs()[0].toString()));
	}

	private ErrorLog constructErrorLogObject(String errorType, String errorDesc, String payload) {
		ErrorLog errorLog = new ErrorLog();
		errorLog.setErrorType(errorType);
		errorLog.setErrorDesc(errorDesc);
		errorLog.setPayload(payload);
		return errorLog;
	}
}
