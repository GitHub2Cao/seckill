package org.seckill.test.java8.optional;

import java.util.Optional;


public class TestOptional {
	public static void main(String[] args) {
		Optional<String> emptyOpt = Optional.empty();
//		emptyOpt.get(); //NoSuchElementException
	
		Optional<String> opt = Optional.ofNullable("111");
		
		//System.out.println(opt.get()); // No value present
		System.out.println(opt.filter(item -> item.length() > 0).orElseGet(() -> "xxxx"));
		
		Optional<String> optStr = Optional.ofNullable("b");
		
		optStr.ifPresent(System.out::println);
		
		System.out.println(optStr.orElse("aaaa"));
	}
}
