package org.seckill.test.guava.preconditions;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ttt();
	}

	public static void ttt() {
		System.out.println("a");
		System.out.println("b");

		get();
	}

	public static void get() {
		int i = 0;
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("C");
		for (int i1 = 0; i1 < list.size(); i1++) {
			if (true) {
				System.out.println(list.get(i1));
			}
		}


		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(new Date());
			System.out.println("ccccc"); // jrebel
		}
	}
}
