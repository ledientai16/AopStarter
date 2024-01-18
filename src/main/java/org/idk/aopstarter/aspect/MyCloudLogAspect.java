package org.idk.aopstarter.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    @Before("AspectExpression.forDaoPackage()")

    public void myCloudLogAspect() {
        System.out.println("\n========> THIS IS CLOUD LOG");
    }
}
