package org.seckill.test.jvm;

import java.util.Map;
import java.util.Properties;

/**
 * @author cgm
 * @date 2021-04-18 08:08
 */
public class SystemValue {
	public static void main(String[] args) {
		Map<String, String> systemEvMap = System.getenv();
		systemEvMap.forEach((key, value) -> System.out.println("key = " + key + ", value = " + value));

		System.out.println("--------------------------------");

		Properties systemProperties = System.getProperties();
		systemProperties.forEach((key, value) -> System.out.println("key = " + key + ", value = " + value));

	}
}
