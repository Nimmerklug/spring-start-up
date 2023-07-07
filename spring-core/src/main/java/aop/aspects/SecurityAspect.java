package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
    @Before("aop.aspects.MyPontCuts.allGetMethdods()")
    public void beforeGetSecurityAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetSecurityAdvice: School Security check #2");
    }
}
