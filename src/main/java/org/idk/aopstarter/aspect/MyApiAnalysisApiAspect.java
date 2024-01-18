package org.idk.aopstarter.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalysisApiAspect {

    @Before("AspectExpression.forDaoPackage()")
    public void performApiaAnalysis () {
        System.out.println("\n========> Perform API Analysis");
    }
}
