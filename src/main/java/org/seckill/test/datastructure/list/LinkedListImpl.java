package org.seckill.test.datastructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author cgm
 * @date 2021-04-07 13:48
 */
public class LinkedListImpl<E> implements ListADT<E> {
	protected LinearNode<E> head;
	protected LinearNode<E> tail;
	protected int count;

	public LinkedListImpl() {
		head = null;
		tail = null;
		count = 0;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("the list is null");
		}
		E result = head.getElement();
		head = head.getNext();
		count--;
		return result;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("the list is null");
		}
		E element = tail.getElement();
		LinearNode<E> current;
		LinearNode<E> tempHead = head;
		while (tempHead != null) {
			if (tempHead.getNext() == tail) {
				tempHead.setNext(null);
				current = tempHead;
				tail = current;
				break;
			}
			tempHead = tempHead.getNext();
		}
		count--;
		return element;
	}

	@Override
	public E remove(E element) {
		if (isEmpty()) {
			throw new NoSuchElementException("the list is null");
		}
		boolean found = false;
		LinearNode<E> previous = null;
		LinearNode<E> current = head;
		while (!found && current != null) {
			if (element.equals(current.getElement())) {
				found = true;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		if (!found) {
			throw new NoSuchElementException("the element not find");
		}
		if (size() == 1) {
			head = null;
			tail = null;
		} else if (current == head) {
			head = current.getNext();
		} else if (current == tail) {
			tail = previous;
			tail.setNext(null);
		} else {
			previous.setNext(current.getNext());
		}
		count--;
		return element;
	}

	@Override
	public E first() {
		if (isEmpty()) {
			throw new NoSuchElementException("the list is null");
		}
		return head.getElement();
	}

	@Override
	public E last() {
		if (isEmpty()) {
			throw new NoSuchElementException("the list is null");
		}
		return tail.element;
	}

	@Override
	public boolean contains(E target) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder(", ");
		LinearNode tempNode = head;
		while (tempNode != null) {
			stringBuilder.append(tempNode.getElement()).append(", ");
			tempNode = tempNode.getNext();
		}

		return stringBuilder.toString().replaceFirst(", ", "");
	}


	class LinearNode<E> {
		private E element;
		private LinearNode next = null;

		public LinearNode(E element) {
			this.element = element;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public LinearNode getNext() {
			return next;
		}

		public void setNext(LinearNode next) {
			this.next = next;
		}
	}
}
