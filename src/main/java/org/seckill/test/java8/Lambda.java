package org.seckill.test.java8;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Lambda {
	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		
		List<A> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		
		System.out.println(list.stream().filter(x -> x.getAa() != null && x.getAa().length() != 0).map(A::getAa).collect(Collectors.toSet()));
		System.out.println(list.stream().map(A::getAa).collect(Collectors.toList()));
	}
	
	
	
	static class A {
		private String aa;
		private String bb;
		public String getAa() {
			return aa;
		}
		public void setAa(String aa) {
			this.aa = aa;
		}
		public String getBb() {
			return bb;
		}
		public void setBb(String bb) {
			this.bb = bb;
		}
	}
}
