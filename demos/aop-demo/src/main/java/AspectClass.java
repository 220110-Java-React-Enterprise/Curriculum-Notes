import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectClass {
    public AspectClass() {
        System.out.println("AspectClass Constructor");
    }

    @Before("execution(* TestClass.testJoinPoint())")
    public void beforeAdvice() {
        System.out.println("Advice: before");
    }

    @After("execution(* TestClass.testJoinPoint())")
    public void afterAdvice() {
        System.out.println("Advice: after");
    }

}
