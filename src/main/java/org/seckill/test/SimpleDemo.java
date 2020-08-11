package org.seckill.test;

import com.alibaba.ttl.TtlRunnable;
import org.seckill.test.threadlocal.TransmittableThreadLocalSelf;

public class SimpleDemo {
    public static void main(String[] args) {
        TransmittableThreadLocalSelf<String> context = new TransmittableThreadLocalSelf<>();
        
        //ThreadLocal<String> context = new ThreadLocal<>();
        context.set("value-set-in-parent");
        System.out.println("get ---- " + context.get());

        Runnable task = () -> System.out.println("get ---- " + context.get());
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
