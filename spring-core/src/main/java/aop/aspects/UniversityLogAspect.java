package aop.aspects;

import aop.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLogAspect {

    @Pointcut("execution(* aop.University.getStudentsList*())") //Pointcut reference, to reduce copy/paste
    public void getStudentsListMethod() {
    }

    @Before("getStudentsListMethod()")
    public void beforeGetStudentsListAdvice() {
        System.out.println("beforeGetStudentsListAdvice: LOG before Get Students List Method");
    }

    @After("getStudentsListMethod()")
    public void afterGetStudentsListAdvice() {
        System.out.println("afterGetStudentsListAdvice: LOG after Get Students List Method");
    }

    @AfterReturning(pointcut = "getStudentsListMethod()", returning = "students")
    // can do some manipulation with returned data
    public void afterReturningGetStudentsListAdvice(List<Student> students) {
        Student student = students.get(0);
        student.setName("Sir Mr." + student.getName());
        student.setAvgGrade(1 + student.getAvgGrade());
        System.out.println("afterReturningGetStudentsListAdvice: LOG after work of Get Students List Method");
    }

    @AfterThrowing(pointcut = "getStudentsListMethod()", throwing = "exception") // allow to get ifo about exception
    public void afterThrowingGetStudentsListAdvice(Throwable exception) {
        System.err.println("afterThrowingGetStudentsListAdvice: LOG after Get Students List Method Threw Exception:\n" + exception);
    }

    @Around("getStudentsListMethod()")
    // can work with returning and exceptions but we need to manually manipulate workflow
    public void aroundGetStudentsListAdvice() { //not correct way
        System.out.println("aroundGetStudentsListAdvice: LOG before && after (Around) School Return Book Method");
    }

    @Around("execution(* aop.SchoolLibrary.returnBook*())") // the right way
    public Object aroundReturnBookAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // manually proceed target methods
        System.out.println("-".repeat(50));
        System.out.println("aroundReturnBookAdvice: LOG before (Around) Get Students List Method");

        Object targetMethodResult = null;
        long start = System.currentTimeMillis();
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.err.println("aroundGetStudentsListAdvice: LOG after (Around) Get Students List Method Threw Exception:\n" + e);
            //right now  targetMethodResult==null because it didn't finish successfully
            targetMethodResult = "Unknown Book Name : NULL";
            //throw e; The Best way to handle exception is to not hide it
        }
        long end = System.currentTimeMillis();

        if (targetMethodResult instanceof String s) {
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            targetMethodResult = (Object) sb.toString();
        }

        System.out.println("aroundGetStudentsListAdvice: LOG after (Around) Get Students List Method");
        System.out.println(proceedingJoinPoint.getSignature() + "took " + (end - start) + " MilliSeconds");
        System.out.println("-".repeat(50));
        return targetMethodResult;
    }
}
