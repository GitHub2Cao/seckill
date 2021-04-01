package com.alibaba.alibole;

/**
 * @author cgm
 * @date 2021-03-01 21:58
 */
public class OddAndEvenPrinterGame {
	private static final String ODD = "Odd";
	private static final String EVEN = "Even";
	private static final int MAX = 100;
	private static final int STEP = 2;

	public static void main(String[] args) {
		OddAndEvenPrinterGame oddAndEvenPrinterGame = new OddAndEvenPrinterGame();
		Thread oddPrinter = new Thread(oddAndEvenPrinterGame::printOdd, ODD);
		oddPrinter.setPriority(10);

		Thread evenPrinter = new Thread(oddAndEvenPrinterGame::printEven, EVEN);
		evenPrinter.setPriority(1);

		oddPrinter.start();
		// 保证 oddPrinter 先启动， 优先级不够 控制。
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		evenPrinter.start();


	}

	public synchronized void printOdd() {
		boolean finished = false;
		while (!finished) {
			for (int i = 1; i <= MAX; i += STEP) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				this.notify();
				if (i == 99) {
					finished = true;
				}
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " game over");
	}

	public synchronized void printEven() {
		boolean finished = false;
		while (!finished) {
			for (int i = 2; i <= MAX; i += STEP) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				this.notify();
				if (i == 100) {
					finished = true;
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " game over");
	}
}
