package org.seckill.test.jvm;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cgm
 * @create 2021-04-01 16:43
 */
public class OOMTest {
	public static final int _1MB = 1024 * 1024;
	static List<byte[]> byteList = new ArrayList<>();

	private static void oom() {
		//		try {
		//			String response = "oom begin!";
		//			exchange.sendResponseHeaders(200, response.getBytes().length);
		//			OutputStream os = exchange.getResponseBody();
		//			os.write(response.getBytes());
		//			os.close();
		//		} catch (Exception ex) {
		//		}
		//		for (int i = 0; ; i++) {
		//			byte[] bytes = new byte[_1MB];
		//			byteList.add(bytes);
		//			System.out.println(i + "-----------MB");
		//			memPrint();
		//			try {
		//				Thread.sleep(1000);
		//			} catch (Exception e) {
		//			}
		//		}

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();

		new Thread(
				() -> {
					while (true) {
						System.out.println(Thread.currentThread().getName());
					}
				})
				.start();
	}

	static void memPrint() {
		for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
			System.out.println(memoryPoolMXBean.getName() +
					"  committed:" + memoryPoolMXBean.getUsage().getCommitted() +
					"  used:" + memoryPoolMXBean.getUsage().getUsed());
		}
	}

	private static void srv() throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
		HttpContext context = server.createContext("/");
		//context.setHandler(OOMTest::oom);
		server.start();
	}

	public static void main(String[] args) throws Exception {
		//srv();
		oom();
	}
}
