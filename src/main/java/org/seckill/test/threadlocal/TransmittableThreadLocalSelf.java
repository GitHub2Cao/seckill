package org.seckill.test.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

public class TransmittableThreadLocalSelf<T> extends TransmittableThreadLocal<T> {
    @Override
    protected void afterExecute() {
        System.out.println("-=-=-==-==-=-afterExecute=-=-=-=-=-=-");
    }
    @Override
    protected void beforeExecute() {
        System.out.println("-=-=-==-==-=-beforeExecute=-=-=-=-=-=-");
    }
}
