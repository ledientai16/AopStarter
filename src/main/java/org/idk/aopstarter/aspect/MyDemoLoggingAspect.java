package org.idk.aopstarter.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.idk.aopstarter.Account;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Around("execution(* org.idk.aopstarter.service.TrafficFortuneService.*(..))")
    public Object myAroundAspect (
            ProceedingJoinPoint theJoinPoint
    ) throws Throwable {
        // print out method
        String method = theJoinPoint.getSignature().toShortString();
        System.out.print("================> AROUND ASPECT: " + method);
        Object result;
        try {
            Long startMs = System.currentTimeMillis();
            result = theJoinPoint.proceed();
            Long endMs = System.currentTimeMillis();

            Long duration = endMs - startMs;

            System.out.println("\nDuration = " + duration / 1000.0);
        } catch (Exception theExc) {
            System.out.print("================> AROUND ASPECT EXCEPTION: " + theExc.getMessage());
             throw theExc;
        }

        return result;
    }
    // @Before("execution(public void org.idk.aopstarter.dao.AccountDao.addAccount() )")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*())")
    // @Before("execution(* org.idk.aopstarter.dao.*.*(..))")
    // @Before("forDaoPackage()")
    @Before("AspectExpression.forDaoPackage()")
    public void beforeAddAccountAspect(JoinPoint theJoinPoint) {

        System.out.println("\n========> Before add Account Aspect run");

        // Display method signatures
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method Signatures: " + methodSignature);
        // Show args
        Object [] args = theJoinPoint.getArgs();

        for (Object tempObject : args) {
            System.out.println(tempObject);

            if (tempObject instanceof Account) {
                Account theAccount = (Account) tempObject;
                System.out.println("The Account Name: " + theAccount.getFirstName());
            }
        }
    }

//    @Before("execution(* add*(org.idk.aopstarter.Account,..))")

    public void beforeAddAccountAspect () {
        System.out.println("\n========>2- Before add Account Aspect run");
    }
    @AfterReturning(
            pointcut ="execution(* org.idk.aopstarter.dao.AccountDao.findAccount(..))",
            returning = "result"
    )
    public void afterFindAccountWithAspect(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("=>>>>>>> after Find Account With Aspect: " + method);

        System.out.println(result);
        // Post process the data
        convertAccountToUppercase(result);
    }
    @AfterThrowing(
            pointcut = "execution(* org.idk.aopstarter.dao.AccountDao.findAccount(..))",
            throwing = "theExc"
    )
    private void afterThrowingFindAccountAspect(JoinPoint theJoinPoint, Exception theExc) {
        System.out.println("==========> This is exception: " + theExc);
    }
    @After("execution(* org.idk.aopstarter.dao.AccountDao.findAccount(..))")
    private void afterFindAccountAspect(JoinPoint theJoinPoint) {
        System.out.println("==========> AFTER FINALLY ASPECT");
    }
    private void convertAccountToUppercase(List<Account> result)
    {
        for(Account tempAccount : result) {
            tempAccount.setFirstName(tempAccount.getFirstName().toUpperCase());
            tempAccount.setLastName(tempAccount.getLastName().toUpperCase());
        }
    }
}

