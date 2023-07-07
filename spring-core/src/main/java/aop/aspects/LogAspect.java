package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-5)
public class LogAspect {
    @Before("aop.aspects.MyPontCuts.allGetMethdods()")
    public void beforeGetLoginAdvice(JoinPoint joinPoint) { //JoinPoint get access to methodSignature and arguments and more
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] arguments = joinPoint.getArgs();
        System.out.println("-".repeat(50));
        System.out.println("beforeGetLoginAdvice: School Loggin check #-5");
        System.out.println("MethodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName());
        System.out.println("*".repeat(50));

        for (Object obj : arguments) {
            if (obj instanceof Book mybook) {
                System.out.printf("Book Info:%nName:%s%nAuthor:%s%nPublicationYear:%d%n",
                        mybook.getName(), mybook.getAuthor(), mybook.getPublicationYear());
            } else if (obj instanceof String s) {
                System.out.printf("String Name:%s%n", s);
            }
            System.out.println(obj);
        }

        System.out.println("-".repeat(50));
    }

}
