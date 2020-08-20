package org.seckill.test.threadlocal;

import com.alibaba.ttl.TtlRunnable;

public class SimpleDemo {
    public static void main(String[] args) {
        TransmittableThreadLocalSelf<String> context = new TransmittableThreadLocalSelf<>();
        
        //ThreadLocal<String> context = new ThreadLocal<>();
        context.set("value-set-in-parent");
        System.out.println("get ---- " + context.get());

        Runnable task = () -> {
        	System.out.println("get ---- " + context.get());
        	System.out.println(Thread.currentThread().getName());
        	System.out.println(Thread.currentThread().getClass());
        	
        	
        	
        	
        };
        // 额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);

        Thread thread = new Thread(ttlRunnable);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get ---- " + context.get());
    }
}
