package org.seckill.test.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

public class TransmittableThreadLocalSelf<T> extends TransmittableThreadLocal<T> {
    @Override
    protected void afterExecute() {
        //System.out.println(Thread.currentThread().getState() + "-=-=-==-==-=-afterExecute=-=-=-=-=-=-");
    	System.out.println("+++" + get());
    	//set(null);
    	//TransmittableThreadLocal.Transmitter.restore(null);
        System.out.println("===" + get());
    }
}
