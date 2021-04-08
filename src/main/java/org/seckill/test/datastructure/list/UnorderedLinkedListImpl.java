package org.seckill.test.datastructure.list;

import java.util.NoSuchElementException;

/**
 * @author cgm
 * @date 2021-04-07 14:10
 */
public class UnorderedLinkedListImpl<E> extends LinkedListImpl<E> implements UnorderedListADT<E> {
	@Override
	public void add2Front(E element) {
		LinearNode<E> node = new LinearNode<E>(element);
		if (isEmpty()) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
		count++;
	}

	@Override
	public void add2Rear(E element) {
		LinearNode<E> node = new LinearNode<E>(element);
		if (isEmpty()) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
		count++;
	}

	@Override
	public void addAfter(E element, E target) {
		LinearNode<E> node = new LinearNode<E>(element);
		LinearNode<E> current = head;
		boolean found = false;
		while (current != null && !found) {
			if (target.equals(current.getElement())) {
				found = true;
			} else {
				current = current.getNext();
			}
		}
		if (!found) {
			throw new NoSuchElementException("the element not find " + target);
		}
		node.setNext(current.getNext());
		current.setNext(node);
		count++;
	}

	@Override
	public void addBefore(E element, E target) {
		LinearNode<E> node = new LinearNode<E>(element);
		LinearNode<E> previous = null;
		LinearNode<E> current = head;
		boolean found = false;
		while (current != null && !found) {
			if (target.equals(current.getElement())) {
				found = true;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		if (!found) {
			throw new NoSuchElementException("the element not find " + target);
		}
		if (current == head) {
			node.setNext(head);
			head = node;
		} else {
			node.setNext(previous.getNext());
			previous.setNext(node);
		}

		count++;
	}

	public static void main(String[] args) {
		UnorderedListADT<String> list = new UnorderedLinkedListImpl<>();
		list.add2Front("a");
		System.out.println(list.toString() + " ____ " + list.size());
//		System.out.println(list.removeFirst());
//		System.out.println(list.toString() + " ____ " + list.size());
		list.add2Front("b");
		System.out.println(list.toString() + " ____ " + list.size());
		list.add2Front("c");
		System.out.println(list.toString() + " ____ " + list.size());
		list.add2Front("d");
		System.out.println(list.toString() + " ____ " + list.size());
		list.addAfter("bb", "b");
		System.out.println(list.toString() + " ____ " + list.size());
		list.addAfter("bbb", "bb");
		System.out.println(list.toString() + " ____ " + list.size());
		list.addAfter("aa", "d");
		System.out.println(list.toString() + " ____ " + list.size());


		list.addBefore("1", "a");
		System.out.println(list.toString() + " ____ " + list.size());

		list.addBefore("2", "d");
		System.out.println(list.toString() + " ____ " + list.size());

		list.addBefore("3", "c");
		System.out.println(list.toString() + " ____ " + list.size());

//		list.addAfter("bbb", "bba");
//		System.out.println(list.toString() + " ____ " + list.size());

//		System.out.println(list.removeLast());
//		System.out.println(list.toString() + " ____ " + list.size());
//		System.out.println(list.removeLast());
//		System.out.println(list.toString() + " ____ " + list.size());

//		System.out.println(list.removeFirst());
//		System.out.println(list.toString() + " ____ " + list.size());

//		list.add2Rear("a");
//		System.out.println(list.toString() + " ____ " + list.size());
//		list.add2Rear("b");
//		System.out.println(list.toString() + " ____ " + list.size());
//		list.add2Rear("c");
//		System.out.println(list.toString() + " ____ " + list.size());
//		list.add2Rear("d");
//		System.out.println(list.toString() + " ____ " + list.size());


//		System.out.println(list.remove("d"));
//		System.out.println(list.toString() + " ____ " + list.size());
	}
}
