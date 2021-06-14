package org.seckill.test.system;

/**
 * @author cgm
 * @create 2021-02-26 15:51
 */
public class TestSystem {
	public static void main(String[] args) {
		System.getenv().forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		System.out.println("++++++++++++++++++++++++++++");
		System.getProperties()
				.forEach(
						(key, value) -> {
							System.out.println(key + " : " + value);
						});

		System.out.println(System.getProperty("sun.arch.data.model"));


		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					int i = 1;
					i++;
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					int i = 1;
					i++;
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					int i = 1;
					i++;
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					int i = 1;
					i++;
				}
			}
		}).start();

	}


}
