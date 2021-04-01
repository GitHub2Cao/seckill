package org.seckill.test.threadlocal;

/**
 * @author cgm
 * @create 2021-02-25 11:00
 */
public class Lazy {
	private static boolean initialized = false;

//	static {
//		Thread t = new Thread(() -> initialized = true);
//		t.start();
////		try {
////			//t.join();
////		} catch (InterruptedException e) {
////			throw new AssertionError(e);
////		}
//	}

	static {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				initialized = true;
			}
		});
		t.start();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			throw new AssertionError(e);
//		}
	}

	public static void main(String[] args) {
		System.out.println(initialized);
	}
}
