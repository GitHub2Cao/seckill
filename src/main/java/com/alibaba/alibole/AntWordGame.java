package com.alibaba.alibole;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author cgm
 * @date 2021-03-18 14:58
 * 有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC:
 */
public class AntWordGame {
	private int flag = 1;

	public static void main(String[] args) throws InterruptedException {
		AntWordGame antWordGame = new AntWordGame();

		CountDownLatch countDownLatch = new CountDownLatch(3);

		int corePoolSize = 3;
		int maximumPoolSize = 10;
		long keepAliveTime = 60;
		TimeUnit unit = TimeUnit.MILLISECONDS;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
		ExecutorService pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);

		pool.execute(() -> extracted(antWordGame::printA, antWordGame, countDownLatch));
		pool.execute(() -> extracted(antWordGame::printB, antWordGame, countDownLatch));
		pool.execute(() -> extracted(antWordGame::printC, antWordGame, countDownLatch));

		pool.shutdown();

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("game over");
	}

	public void printA(AntWordGame antWordGame) {
		int count = 1;
		boolean finished = false;
		while (!finished) {
			if (count == 10) {
				finished = true;
			}
			synchronized (antWordGame) {
				while (flag != 1) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("A");
				flag = 2;
				count++;
				this.notifyAll();
			}
		}
	}

	public void printB(AntWordGame antWordGame) {
		int count = 1;
		boolean finished = false;
		while (!finished) {
			if (count == 10) {
				finished = true;
			}
			synchronized (antWordGame) {
				while (flag != 2) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("B");
				flag = 3;
				count++;
				this.notifyAll();
			}
		}
	}

	public void printC(AntWordGame antWordGame) {
		int count = 1;
		boolean finished = false;
		while (!finished) {
			if (count == 10) {
				finished = true;
			}
			synchronized (antWordGame) {
				while (flag != 3) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("C");
				flag = 1;
				count++;
				this.notifyAll();
			}

		}
	}

	private static void extracted(Consumer<AntWordGame> consumer, AntWordGame antWordGame, CountDownLatch countDownLatch) {
		try {
			consumer.accept(antWordGame);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			countDownLatch.countDown();
		}
	}
}