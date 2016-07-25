package com.liantuo.trade.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.liantuo.trade.client.trade.packet.Paging;
@Component
@Aspect
public class ReferencePointcutAspect {
//	@Pointcut("execution(* com.liantuo.trade.web.controller.local.TradeEntryController.*(..))")
//	public void controller(){}
	@Pointcut("@annotation(com.liantuo.trade.spring.annotation.Page)")
	public void controller(){}
	
	@Before("controller()")
	public void QueryBefore(JoinPoint jp) throws Exception{
//		System.out.println("******************************");
		Object[] args = jp.getArgs();
		for (int i = 0; i < args.length; i++) {
//			System.out.println(args[i] instanceof Paging);
			if(args[i] instanceof Paging){
				Paging page = (Paging) args[i];
				String _page = StringUtils.isEmpty(page.getPage())?"0":page.getPage();
				String _page_size=StringUtils.isEmpty(page.getPage_size())?"50":page.getPage_size();
				PageHelper.startPage((0 == Integer.valueOf(_page)) ? 1 : (Integer.valueOf(_page) + 1),
						Integer.valueOf(_page_size));
			}
		}
	}
	
	
//	@Around("controller()")
	public void watchPerformance(ProceedingJoinPoint joinpoint) {  
        try {  
            System.out.println("oooooooo环绕通知开始oooooooo");  
            long start = System.currentTimeMillis();  
            Object proceed = joinpoint.proceed();
            System.out.println(proceed);
            long end = System.currentTimeMillis();  
            System.out.println("oooooooo环绕通知结束oooooooo");  
            System.out.println("演出耗时共计：" + (end - start)  
                    + "毫秒。");  
        } catch (Throwable t) {  
            System.out.println("Boo!Wewantourmoneyback!");  
        }  
    }  
}
