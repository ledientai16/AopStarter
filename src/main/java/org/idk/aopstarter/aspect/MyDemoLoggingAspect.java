package org.idk.aopstarter.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(public void org.idk.aopstarter.dao.AccountDao.addAccount() )")
    public void beforeAddAccountAspect() {
        System.out.println("\n========> Before add Account Aspect run");
    }
}
