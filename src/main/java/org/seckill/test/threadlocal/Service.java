package org.seckill.test.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.alibaba.ttl.threadpool.TtlExecutors;

public class Service {
	private static ExecutorService tomcatExecutors = Executors.newFixedThreadPool(1); // dubbo mq mvc 线程 
	
	private static ExecutorService businessExecutors = TtlExecutors.getTtlExecutorService(
			new ThreadPoolExecutorSelf(4, 4,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>())); // 回调
	
	private static TransmittableThreadLocalSelf<String> requestIdThreadLocal = new TransmittableThreadLocalSelf<>();

	public static void main(String[] args) {
		ControlThread dubbo = new ControlThread(1, "dubbo");
//		ControlThread mq = new ControlThread(2, "mq");
//		ControlThread mvc = new ControlThread(3, "mvc");
		tomcatExecutors.submit(dubbo);
//		tomcatExecutors.submit(mq);
//		tomcatExecutors.submit(mvc);
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		System.out.println("+++++++++++++++++++++++++++");
//		
//		dubbo.setSec(true);
//		mq.setSec(true);
//		mvc.setSec(true);
//		
//		tomcatExecutors.submit(dubbo);
//		tomcatExecutors.submit(mq);
//		tomcatExecutors.submit(mvc);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		businessExecutors.shutdown();
		tomcatExecutors.shutdown();
	}

	static class ControlThread implements Runnable {
		private int i;
		private String name;
		private boolean sec = false;

		public ControlThread(int i, String name) {
			this.i = i;
			this.name = name;
		}

		public int getI() {
			return i;
		}

		public String getName() {
			return name;
		}

		public boolean isSec() {
			return sec;
		}

		public void setSec(boolean sec) {
			this.sec = sec;
		}

		@Override
		public String toString() {
			return "ControlThread [i=" + i + ", name=" + name + "]";
		}

		@Override
		public void run() {
			//System.out.println(this);
			if (!this.isSec()) requestIdThreadLocal.set(this.toString() + " local");
			
			businessExecutors.submit(new BusinessTask(this.toString()));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			System.out.println(this + "+++++" + requestIdThreadLocal.get());
		}
	}

	static class BusinessTask implements Runnable {
		private String parentThreadName;

		public BusinessTask(String parentThreadName) {
			this.parentThreadName = parentThreadName;
		}

		@Override
		public void run() {
			System.out.println(parentThreadName + " ---- " + requestIdThreadLocal.get());
		}
	}
}