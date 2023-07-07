package aop.aspect_oriented_programing.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //Require  @Component @EnableAspectJAutoProxy
@Component
public class AuthenticationAspect {
    //we define for what particular class to execute the method (for all methods)
    @Pointcut("within(aop.aspect_oriented_programing.demo..*)")
    public void authorizationPointCut() {
        System.out.println("authorizationPointCut");
    }

    //within(<packages class path>.<method>(<arguments>))
    @Pointcut("within(aop.aspect_oriented_programing.demo..*)")
    public void authenticationPointCut() {
        System.out.println("authenticationPointCut");
    }

    @Before("authenticationPointCut() && authorizationPointCut()")
    public void authentication() {
        System.out.println("Authenticating The Request");
    }
}
