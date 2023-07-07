package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // tell sprint that this not a simple class
public class LogicAspect {
    /*
    Advices:
    Before
    After returning
    After throwing
    After finally
    Around
    */
    @Before("execution(public void getBook())") //pointcut |execution(* *(..))|
    // | execution(modifiers-pattern? return-type-pattern! declaring-type-pattern? method-name-pattern! (parameters pattern!) throws-pattern?) |
    public void beforeGetBookAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetBookAdvice: attempt to take book");
    }

    @Before("execution(public void aop.UniLibrary.getBook())")
    public void beforeGetUniBookAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetUniBookAdvice: attempt to take book from UniLibrary");
    }

    @Before("execution(public void get*())")
    public void beforeGetMethodAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetMethodAdvice: attempt to call Get Method");
    }

    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeReturnBookAdvice: attempt to return book");
    }

    @Before("execution(public void getBook(aop.Book))")
    public void beforeGetBookWithNameAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetBookWithNameAdvice: attempt to take book");
    }

    @Before("execution(public void getBook(..))")
    public void beforeGetNameBookAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetNameBookAdvice: attempt to take book");
    }

}
