package com.zhiming.core.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/async",asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("主线程"+Thread.currentThread()+"开始...开始时间=》》》"+System.currentTimeMillis());

        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread()+"开始...开始时间=》》》"+System.currentTimeMillis());
                    sayHello();

                    AsyncContext asyncContext1 = req.getAsyncContext();
                    ServletResponse response = asyncContext1.getResponse();
                    response.getWriter().write("hello 子线程hello");
                    System.out.println("子线程"+Thread.currentThread()+"结束...结束时间=》》》"+System.currentTimeMillis());
                    asyncContext.complete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("主线程"+Thread.currentThread()+"结束...结束时间=》》》"+System.currentTimeMillis());

    }


    public void sayHello() throws Exception{
        System.out.println(Thread.currentThread()+" processing...");
        Thread.sleep(3000);
    }
}
