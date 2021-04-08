package org.seckill.test.datastructure.stack;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author cgm
 * @create 2021-04-06 13:49
 */
public class LinkedStack<E> implements Stack<E> {
	private int count;
	private LinearNode<E> head;

	public LinkedStack() {
		this.count = 0;
		head = null;
	}

	@Override
	public void push(E element) {
		Objects.requireNonNull(element, "element must not null");
		LinearNode node = new LinearNode(element);
		node.setNext(head);
		head = node;
		count++;
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack is null");
		}
		E element = head.getElement();
		head = head.getNext();
		count--;

		return element;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack is null");
		}
		return head.getElement();
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
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		LinearNode tempHead = this.head;
		stringBuilder.append(", ");
		while (tempHead != null) {
			stringBuilder.append(tempHead.getElement());
			tempHead = tempHead.getNext();
			if (tempHead == null) {
				break;
			}
		}
		return stringBuilder.toString().replaceFirst(", ", "");
	}

	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<>();
		System.out.println(stack.toString() + " ___ " + stack.size());
		stack.push("a");
		System.out.println(stack.peek());
		stack.push("b");
		System.out.println(stack.peek());
		stack.push("c");
		System.out.println(stack.peek());
		System.out.println(stack.toString() + " ___ " + stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.toString() + " ___ " + stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.toString() + " ___ " + stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.toString() + " ___ " + stack.size());

		System.out.println(stack.peek());
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


