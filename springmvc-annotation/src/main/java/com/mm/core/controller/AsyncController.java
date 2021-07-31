package com.mm.core.controller;

import com.mm.core.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
public class AsyncController {


    @ResponseBody
    @RequestMapping("/async")
    public Callable<String> async() {

        System.out.println("主线程start"+Thread.currentThread());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {

                System.out.println("子线程start"+Thread.currentThread());
                Thread.sleep(5000);
                System.out.println("子线程end"+Thread.currentThread());
                return "子线程callable";
            }
        };
        System.out.println("主线程end"+Thread.currentThread());
        return callable;
    }

    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult = new DeferredResult((long)3000,"创建create fail...");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success"+order;
    }
}
