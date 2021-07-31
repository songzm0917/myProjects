package com.mm.core;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DeferredResultQueue {
    private static Queue<DeferredResult<Object>>  queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

    public static DeferredResult<Object> get() {

        return queue.poll();
    }

    public static void save(DeferredResult<Object> result) {
        queue.add(result);
    }

}
