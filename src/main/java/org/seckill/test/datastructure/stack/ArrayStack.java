package org.seckill.test.datastructure.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author cgm
 * @date 2021-04-06 12:41
 */
public class ArrayStack<E> implements Stack<E> {
	private int top;

	private E[] elements;

	public ArrayStack(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException("initialCapacity must biger then 0");
		}
		this.top = 0;
		this.elements = (E[]) new Object[initialCapacity];
	}

	public ArrayStack() {
		this.top = 0;
		int DEFAULT_CAPACATY = 100;
		this.elements = (E[]) new Object[DEFAULT_CAPACATY];
	}

	@Override
	public void push(E element) {
		Objects.requireNonNull(element, "element must not null");
		if (top == elements.length) {
			expandCapacity();
		}
		elements[top] = element;
		top++;
	}

	/**
	 * 扩容.
	 */
	private void expandCapacity() {
		elements = Arrays.copyOf(elements, elements.length << 1);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack is empty!");
		}
		top--;
		E element = elements[top];
		elements[top] = null;
		return element;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack is empty!");
		}
		return elements[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public String toString() {
		return Arrays.deepToString(elements);
	}

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>(3);
		System.out.println(stack.toString() + "----" + stack.size());
		stack.push(1);
		System.out.println(stack.peek());
		stack.push(2);
		System.out.println(stack.peek());
		System.out.println(stack.toString() + "----" + stack.size());
		stack.push(3);
		System.out.println(stack.toString() + "----" + stack.size());
		System.out.println(stack.peek());
		stack.push(4);
		System.out.println(stack.peek());
		System.out.println(stack.toString() + "----" + stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.toString() + "----" + stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.toString() + "----" + stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.toString() + "----" + stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.toString() + "----" + stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.toString() + "----" + stack.size());
	}
}
