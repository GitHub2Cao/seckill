package org.seckill.test.system;

/**
 * @author cgm
 * @create 2021-03-07 12:17
 */
public class TestClassLoader {
	public static void main(String[] args) {
		System.out.println("name ---- " + ClassLoader.getSystemClassLoader().getName());
		System.out.println("parent ==== " + ClassLoader.getSystemClassLoader().getParent().getName());
		System.out.println("parent ==== " + ClassLoader.getSystemClassLoader().getParent().getParent());
	}
}
