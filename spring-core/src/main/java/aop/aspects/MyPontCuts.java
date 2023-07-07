package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPontCuts {
    @Pointcut("execution(* aop.SchoolLibrary.get*(..))") //Pointcut reference, to reduce copy/paste
    public void allGetMethdods() {
    }
}
