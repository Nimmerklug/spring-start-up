package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogginAndSecurityAspect {

    @Pointcut("execution(* get*())") //Pointcut reference, to reduce copy/paste
    private void allGetMethdods() {
    }

    @Pointcut("execution(* aop.UniLibrary.get*())")
    private void allGetMethdodsFromUniLibrary() {
    }

    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMethdodsFromUniLibrary() {
    }

    @Pointcut("allGetMethdodsFromUniLibrary() ||allReturnMethdodsFromUniLibrary()")
    private void allGetAndReturnMethdodsFromUniLibrary() {
    }

    @Before("allGetMethdods()")
    public void beforeGetLogginAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetLogginAdvice: Loggin check");
    }

    @Before("allGetMethdods()")
    public void beforeGetSecurityAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetSecurityAdvice: Security check");
    }

    @Before("allGetMethdodsFromUniLibrary()")
    public void beforeGetULogginAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetULogginAdvice: GET Loggin check from UniLibrary");
    }

    @Before("allReturnMethdodsFromUniLibrary()")
    public void beforeReturnULogginAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeReturnULogginAdvice: RETURN Loggin check from UniLibrary");
    }

    @Before("allGetAndReturnMethdodsFromUniLibrary()")
    public void beforeGetAndReurnULogginAdvice() { //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetAndReurnULogginAdvice: GET & RETURN Loggin check from UniLibrary");
    }


    /* Use above Instead of
    @Before("execution(* get*())")
    public void beforeGetLogginAdvice(){ //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetLogginAdvice: Loggin check");
    }

    ...

    @Before("execution(* get*())")
    public void beforeGetSecurityAdvice(){ //Advice!=Recommendation, it's Aspect methods, it explains what should happen before action
        System.out.println("beforeGetSecurityAdvice: Security check");
    }
     */

}
