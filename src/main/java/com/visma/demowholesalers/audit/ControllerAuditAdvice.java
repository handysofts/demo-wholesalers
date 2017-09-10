package com.visma.demowholesalers.audit;

import com.visma.demowholesalers.utils.MyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Write log about all inbound and outbound messages of Controllers
 *
 * @author vamustafayev
 */
@Component
@Aspect
public class ControllerAuditAdvice {

    private Logger logger = LoggerFactory.getLogger(ControllerAuditAdvice.class);


    /**
     * write log for all in and out results in controllers which use @Audit annotation
     *
     * @param joinPoint
     * @param audit
     * @return
     * @throws Throwable
     */
    @Around("execution(public * com.handysofts.moodmusic.wss.stereotypes.controllers..*Controller.*(..)) && @annotation(audit) ")
    public Object audit(ProceedingJoinPoint joinPoint, Audit audit) throws Throwable {
        long requestStartTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();

        HttpServletRequest request = null;
        HttpSession session = null;

        String methodSignature = audit.value() + " | " + joinPoint.getSignature().getName() + "\n(" + toString(joinPoint.getArgs()) + "\n)";
        String threadUniqueKey = MyUtils.getUniqueThreadName("audit");

        logger.info("Started => {} | {}", threadUniqueKey, methodSignature);

        Object returnObj = joinPoint.proceed();// execute the method

        logger.info("Ended => {} | {}", threadUniqueKey, (returnObj instanceof byte[] ? "returnObj is byte[]" : returnObj));
        logger.info("Execution time => {} | {} milli seconds", threadUniqueKey, (System.currentTimeMillis() - requestStartTime));

        return returnObj;
    }




    /**
     * Customized toString method.
     * If argument contains HttpServletRequest type argument then print remote IP
     *
     * @param args
     * @return
     */
    private String toString(Object[] args) {
        if (args == null)
            return "null";

        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            String s = arg != null ? String.valueOf(arg) : "null";

            if (arg != null && arg instanceof HttpServletRequest) {
                HttpServletRequest req = (HttpServletRequest) arg;
                s = "ip=" + MyUtils.getIPAddress(req);
            }

            sb.append("\n\t").append(s);
        }

        return sb.toString();
    }

}
