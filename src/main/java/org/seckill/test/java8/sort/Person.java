package org.seckill.test.java8.sort;

/**
 * @author cgm
 * @create 2021-02-23 16:27
 */
public class Person {
	private String name;
	private Integer age;
	private String tag;

	public Person(String name, Integer age, String tag) {
		this.name = name;
		this.age = age;
		this.tag = tag;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", tag='" + tag + '\'' +
				'}';
	}
}
