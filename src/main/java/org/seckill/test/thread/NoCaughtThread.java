package org.seckill.test.thread;

/**
 * @author cgm
 * @create 2021-03-07 13:41
 */
public class NoCaughtThread {
	public static void main(String[] args) {
		try {
			Thread thread = new Thread(new Task());
			thread.start();
		} catch (Exception e) {
			System.out.println("==Exception: " + e.getMessage());
		}
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		System.out.println(3 / 2);
		System.out.println(3 / 0);
		System.out.println(3 / 1);
	}
}

