package com.study.schedule.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.concurrent.Future;

@Service("asyncService")
public class AsyncService {

    @Async
    public void asyncTask() {
        System.out.println("Start execution of async task");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Task Interrupted");
        }
        System.out.println("Complete execution of async task");
    }

    @Async
    public Future<String> asyncWithReturn(String name) {
        System.out.println("Start execution of async task with return for" + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Complete execution of async task with for " + name);
        return new AsyncResult<>("Hello:" + name);
    }
}
