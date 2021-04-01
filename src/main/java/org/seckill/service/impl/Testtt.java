package org.seckill.service.impl;

/**
 * @author cgm
 * @create 2021-02-14 22:44
 */
public class Testtt {


	public static final String STRING = "aaaa";
	public static final String STRING1 = "aaaa";
	public static final String CGM = "cgm";

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

	private String name;
	private Integer age;


	public Testtt() {
	}

	public static void main(String[] args) {
		int i = vilidate();

		get(i);


		put(i);

	}

	private static void put(int i) {
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
	}

	private static void get(int i) {
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
	}

	private static int vilidate() {
		int i = 10;
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
		fi(i, CGM);
		return i;
	}

	private static void fi(int aaa, String cgm) {

		System.out.println(aaa + cgm);
	}
}
