package com.person.cn.aop.com;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ym.y
 * @description
 * @package com.atguigu.aop.com.aop2
 * @updateUser
 * @date 13:06 2021/2/2
 */
@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.person.cn.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {

    }

    /**
     * @description 前置通知
     * @author ym.y
     * @updateUser
     * @date 13:14 2021/2/2
     */
    @Before("pointCut()")
    public void before() {
        System.out.println("before.....");
    }

    /**
     * @description 后置通知
     * @author ym.y
     * @updateUser
     * @date 13:14 2021/2/2
     */
    @After("pointCut()")
    public void after() {
        System.out.println("after.....");
    }

    /**
     * @description 事后返回通知
     * @author ym.y
     * @updateUser
     * @date 13:15 2021/2/2
     */
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning....");
    }

    /**
     * @description 环绕通知
     * @author ym.y
     * @updateUser
     * @date 13:15 2021/2/2
     */
    public void around() {

    }

    /**
     * @description 异常通知
     * @author ym.y
     * @updateUser
     * @date 13:17 2021/2/2
     */
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("参数异常======================");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before.....");
        //回调目标对象原有的方法
        joinPoint.proceed();
        System.out.println("around after.....");

    }
}
