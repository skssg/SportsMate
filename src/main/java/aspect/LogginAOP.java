package aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * packageName    : aspect
 * fileName       : LogginAOP
 * author         : jun
 * date           : 2024. 10. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 18.        jun       최초 생성
 */
@Slf4j
@Aspect
@Component
public class LogginAOP {
    @Pointcut("execution(* com.sportsmate..*(..))")
    public void cut() {};
    @Before(value = "cut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        Object[] args = joinPoint.getArgs();

        log.info("================================= START =================================");
        log.info("--------------------------------- API Controller ---------------------------------");
        log.info("Information           :   " + methodSignature); // toString 메서드 자동으로 실행된다.
        log.info("Method Name           :   " + method);
        log.info("Parameter             :   " + Arrays.toString(args));
    }

}
