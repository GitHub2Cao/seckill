package org.seckill.test.datastructure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author cgm
 * @date 2021-04-06 15:19
 */
public class ArrayQueue<E> implements Queue<E> {
	private E[] elements;
	private int count;

	public ArrayQueue() {
		this.elements = (E[]) new Object[5];
		this.count = 0;
	}

	public ArrayQueue(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException("initialCapacity must bigger then 0");
		}
		this.elements = (E[]) new Object[initialCapacity];
	}

	@Override

	public void enqueue(E element) {
		Objects.requireNonNull(element, "element must not null");
		if (count == elements.length) {
			expandCapacity();
		}
		for (int i = count; i > 0; i--) {
			elements[i] = elements[i - 1];
		}
		elements[0] = element;
		count++;
	}

	/**
	 * double length.
	 */
	private void expandCapacity() {
		elements = Arrays.copyOf(elements, elements.length << 1);
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("the queue is empty");
		}
		E result = elements[count - 1];
		elements[count - 1] = null;
		count--;
		return result;
	}

	@Override
	public E first() {
		if (isEmpty()) {
			throw new NoSuchElementException("the queue is empty");
		}
		return elements[count - 1];
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
		return Arrays.deepToString(elements);
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayQueue<>(3);

		queue.enqueue(1);
		System.out.println(queue.first());
		System.out.println(queue.toString());
		queue.enqueue(2);
		System.out.println(queue.first());
		System.out.println(queue.toString());
		queue.enqueue(3);
		System.out.println(queue.toString());
		queue.enqueue(4);
		System.out.println(queue.toString() + " +++++ " + queue.size());

		System.out.println(queue.dequeue());
		System.out.println(queue.toString() + " +++++ " + queue.size());

		System.out.println(queue.dequeue());
		System.out.println(queue.toString() + " +++++ " + queue.size());

		System.out.println(queue.dequeue());
		System.out.println(queue.toString() + " +++++ " + queue.size());

		System.out.println(queue.dequeue());
		System.out.println(queue.toString() + " +++++ " + queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString() + " +++++ " + queue.size());

	}
}
