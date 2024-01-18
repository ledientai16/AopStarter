package org.idk.aopstarter.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AspectExpression {
    // Declare pointcut expression
    @Pointcut("execution(* org.idk.aopstarter.dao.*.*(..))")
    public void forDaoPackage() {}
    @Pointcut("execution(* org.idk.aopstarter.dao.*.get*(..))")
    public void getter(){}
    @Pointcut("execution(* org.idk.aopstarter.dao.*.set*(..))")
    public void setter(){}
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageWithoutGetOrSet() {}
}
