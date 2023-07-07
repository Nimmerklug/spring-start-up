package aop.aspect_oriented_programing.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //Require  @Component @EnableAspectJAutoProxy
@Component
public class LoggingAspect {
    //we define what we want to call and when with annotations
    @Before("execution(* aop.aspect_oriented_programing.demo.ShoppingCart.checkout())")
    public void before_Logger() {
        System.out.println("Before Logger without argument");
    }

    @Before("execution(* aop.aspect_oriented_programing.demo.ShoppingCart.checkout(String))")
    public void before_Logger_(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        System.out.println("Before Logger with arguments: " + joinPoint.getArgs()[0]);
    }

    //execution(<return type> <packages class path>.<method>(<arguments>))
    @After("execution(* *.checkout(..))")
    public void after_Logger() {
        System.out.println("After Logger");
    }

    @Pointcut("execution(* aop.aspect_oriented_programing.demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {
        System.out.println("After Returning");
    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void after_Returning(String retVal) {
        System.out.println("After Returning String:" + retVal);
    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void after_Returning(int retVal) {
        System.out.println("After Returning Int:" + retVal);
    }
}
