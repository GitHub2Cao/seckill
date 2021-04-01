package org.seckill.test.java8.sort;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author cgm
 * @create 2021-02-23 16:03
 */
public class TestSort {
	public static void main(String[] args) {
		List<Integer> unSortedList = Lists.newArrayList(3, 4, 1, 5);
		System.out.println("unSortedList : " + unSortedList);
		List<Integer> sortedList = unSortedList.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedList : " + sortedList);
		sortedList = unSortedList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println("sortedList : " + sortedList);
		sortedList = unSortedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("sortedList : " + sortedList);

		sortPerson();

	}

	public static void sortPerson() {
		List<Person> persons = getPersonList();
		System.out.println(persons);

		List<Person> sorted = persons.stream().sorted(Comparator.comparingInt(person -> {
			if (Objects.equals(person.getTag(), "Z")) {
				return 1;
			} else {
				return 2;
			}
		})).collect(Collectors.toList());
		System.out.println(sorted);
	}

	public static List<Person> getPersonList() {
		List<Person> persons = Lists.newArrayList();
		Person person1 = new Person("a", 1, "Z");
		Person person2 = new Person("b", 2, "Y");
		Person person3 = new Person("c", 2, "Y");

		persons.add(person1);
		persons.add(person2);
		persons.add(person3);

		return persons;
	}

}


