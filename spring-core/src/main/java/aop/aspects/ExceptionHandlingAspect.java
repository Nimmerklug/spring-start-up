package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("aop.aspects.MyPontCuts.allGetMethdods()")
    public void beforeGetExceptionHandlingAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetExceptionHandlingAdvice: School ExceptionHandling check #3");
    }
}
