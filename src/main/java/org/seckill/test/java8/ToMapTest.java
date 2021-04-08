package org.seckill.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author cgm
 * @create 2021-04-01 17:30
 */
public class ToMapTest {
	public static void main(String[] args) {
		List<AA> list = new ArrayList<>();

		AA a1 = new AA("a", 1);
		AA a2 = new AA("b", 2);
		AA a3 = new AA("b", 3);

		list.add(a1);
		list.add(a2);
		list.add(a3);
		System.out.println(list);
		list.stream().collect(Collectors.toMap(AA::getName, Function.identity(), (v1, v2) -> {
			v1.setAge(v1.getAge() + v2.getAge());
			return v1;
		}));
		System.out.println(list);
	}
}

class AA {
	private String name;
	private Integer age;

	public AA(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "AA{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
