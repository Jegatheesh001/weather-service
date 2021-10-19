package com.projects.weatherservice.configuration.aspects;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Logging business logic
 * 
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On 20-Oct-2020
 *
 */

@Slf4j
@Component
@Aspect
public class LoggingLogic {
	
	@Autowired
	private HttpServletRequest request;

	/**
	 * This Aspect will log request and response and total process time
	 * 
	 * @param joinPoint
	 * @return Object
	 * @throws Throwable
	 */
	@Around("@annotation(TrackLog)")
	public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
		// Setting Basic Details
		StringBuilder logInfo = new StringBuilder();
		logInfo.append("Url: ").append(request.getRequestURI());
		logInfo.append(" | Class: ").append(joinPoint.getSignature().getDeclaringType().getName());
		logInfo.append(" | Method: ").append(joinPoint.getSignature().getName());
		// Setting Request Parameters
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			logInfo.append(" | Requests ");
			Arrays.asList(args).forEach(arg -> logInfo.append("[").append(arg).append("]"));
		}
		// Setting Total Time of Execution
		Object returnValue = null;
		long startTime = System.currentTimeMillis();
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			logInfo.append(" | Total time ").append(System.currentTimeMillis() - startTime).append("ms ")
					.append(" | Exception: ").append(e.getMessage());
			log.info(logInfo.toString());
			throw e;
		}
		logInfo.append(" | Total time ").append(System.currentTimeMillis() - startTime).append("ms ");
		// Setting Response
		setResponseToLog(logInfo, returnValue);
		log.info(logInfo.toString());
		return returnValue;
	}

	/**
	 * Setting Response details to log
	 * 
	 * @param logInfo
	 * @param returnValue
	 */
	private void setResponseToLog(StringBuilder logInfo, Object returnValue) {
		if (returnValue != null) {
			logInfo.append(" | Response ");
			logInfo.append("[" + returnValue + "]");
		}
	}

}
