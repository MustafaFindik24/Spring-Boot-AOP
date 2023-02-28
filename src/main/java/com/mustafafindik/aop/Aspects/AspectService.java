package com.mustafafindik.aop.Aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustafafindik.aop.model.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
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

    @AfterReturning(value = "execution(* com.mustafafindik.aop.Service.*.saveUser(..))",
                    returning = "user")
    public void afterReturning(JoinPoint joinPoint, User user){
        log.info("Kullanıcı kaydedildikten sonra yakalanan parametre: " + user);
    }

    @AfterThrowing(value = "execution(* com.mustafafindik.aop.Service.*.saveUser(..))",
            throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        log.info("Kullanıcı kaydedildikten sonra yakalanan parametre: " + e.getMessage());
    }

    @Pointcut(value = "execution(* com.mustafafindik.aop.Service.*.*(..))")
    public void saveUserPointcut(){}

    @Around("saveUserPointcut()")
    public Object logMethod(ProceedingJoinPoint pjp) throws Throwable{
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        System.out.println("--------------------------------------------------");
        log.info('\n'+ "Metot çalıştırıldı. " +
                 '\n'+ "Sınıf Adı    : " + className +
                 '\n'+ "Metod Adı    : " + methodName + "()" +
                 '\n'+ "Kayıt öncesi : " + objectMapper.writeValueAsString(pjp.getArgs()));
        //Object object = pjp.proceed();
        System.out.println("--------------------------------------------------");
        log.info('\n'+ "Sınıf Adı     : " + className +
                 '\n'+ "Metod Adı     : " + methodName + "()" +
                 '\n'+ "Kayıt sonrası : " + objectMapper.writeValueAsString(pjp.proceed()));
        return null;
    }
}




