package com.mustafafindik.aop.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {

    @Before("execution(* com.mustafafindik.aop.Service.*.saveUser(..))")
    public void BeforeSaveUser(JoinPoint joinPoint){
        System.out.println("Kullanıcı kaydedilmeden önce yakalanan parametre: " + joinPoint.getArgs()[0]);
        System.out.println("Imza parametresi : " + joinPoint.getSignature());
    }
    @After("execution(* com.mustafafindik.aop.Service.*.saveUser(..))")
    public void AfterSaveUser(JoinPoint joinPoint){
        System.out.println("Kullanıcı kaydedildikten sonra yakalanan parametre: " + joinPoint.getArgs()[0]);
        System.out.println("Imza parametresi : " + joinPoint.getSignature());
        System.out.println("Kaynak yeri : " + joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getThis());
    }
}
