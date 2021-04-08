package org.seckill.test.datastructure.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author cgm
 * @date 2021-04-07 12:42
 */
public class UnorderedArrayListImpl<E> extends ArrayListImpl<E> implements UnorderedListADT<E> {
	@Override
	public void add2Front(E element) {
		expandCapacity();
		for (int i = rear; i > 0; i--) {
			elements[i] = elements[i - 1];
		}
		elements[0] = element;
		rear++;
	}

	@Override
	public void add2Rear(E element) {
		expandCapacity();
		elements[rear] = element;
		rear++;
	}

	@Override
	public void addAfter(E element, E target) {
		expandCapacity();
		int index = find(target);
		if (index == NOT_FOUND) {
			throw new NoSuchElementException("not such element find " + target);
		}
		for (int i = rear; i > index + 1; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index + 1] = element;
		rear++;
	}

	@Override
	public void addBefore(E element, E target) {
		expandCapacity();
		int index = find(target);
		if (index == NOT_FOUND) {
			throw new NoSuchElementException("not such element find " + target);
		}
		for (int i = rear; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		rear++;
	}

	/**
	 * double
	 */
	private void expandCapacity() {
		if (rear == elements.length) {
			elements = Arrays.copyOf(elements, elements.length << 1);
		}
	}

	public static void main(String[] args) {
		UnorderedListADT<String> list = new UnorderedArrayListImpl<>();
		list.add2Front("a");

		list.add2Front("b");
		System.out.println(list.toString() + " ____ " + list.size());

		list.add2Front("c");
		System.out.println(list.toString() + " ____ " + list.size());

		list.add2Front("d");
		System.out.println(list.toString() + " ____ " + list.size());

		list.add2Rear("e");
		System.out.println(list.toString() + " ____ " + list.size());

		list.addAfter("ee", "e");
		System.out.println(list.toString() + " ____ " + list.size());

		list.addAfter("eee", "ee");
		System.out.println(list.toString() + " ____ " + list.size());

		list.add2Rear("f");
		System.out.println(list.toString() + " ____ " + list.size());

		list.addAfter("aa", "a");
		System.out.println(list.toString() + " ____ " + list.size());

//		System.out.println(list.removeFirst());
//		System.out.println(list.toString() + " ____ " + list.size());
//		System.out.println(list.removeFirst());
//		System.out.println(list.toString() + " ____ " + list.size());

//		System.out.println(list.removeLast());
//		System.out.println(list.toString() + " ____ " + list.size());
//		System.out.println(list.removeLast());
//		System.out.println(list.toString() + " ____ " + list.size());

//		System.out.println(list.remove("c"));
//		System.out.println(list.toString() + " ____ " + list.size());
//
//		System.out.println(list.remove("bb"));
//		System.out.println(list.toString() + " ____ " + list.size());


	}

}
