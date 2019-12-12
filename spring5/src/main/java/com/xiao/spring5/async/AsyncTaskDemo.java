package com.study.schedule.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncTaskDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AsyncService asyncService = ctx.getBean("asyncService", AsyncService.class);
        for (int i = 0; i < 5; i++) {
            asyncService.asyncTask();
        }

        Future<String> result1 = asyncService.asyncWithReturn("John Mayer");
        Future<String> result2 = asyncService.asyncWithReturn("Eric Clapton");
        Future<String> result3 = asyncService.asyncWithReturn("BB King");
        Thread.sleep(6000);
        System.out.println("result1:" + result1.get());
        System.out.println("result2:" + result2.get());
        System.out.println("result3:" + result3.get());

        ctx.close();
    }
}
