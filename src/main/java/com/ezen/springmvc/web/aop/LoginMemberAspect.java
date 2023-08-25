package com.ezen.springmvc.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoginMemberAspect {

//    @Around("execution(* com.ezen.springmvc.web..*(..)) && args(.., session)")
//    public Object loginMemberCheck(ProceedingJoinPoint joinPoint, HttpSession session) {
//        Object object = null;
//        return object;
//    }

}
