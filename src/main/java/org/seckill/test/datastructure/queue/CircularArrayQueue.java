package org.seckill.test.datastructure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author cgm
 * @create 2021-04-06 17:11
 */
public class CircularArrayQueue<E> implements Queue<E> {
	private int front;
	private int rear;
	private int count;
	private E[] elements;

	public CircularArrayQueue(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException("initialCapacity must biger then 0");
		}
		elements = (E[]) new Object[initialCapacity];
		front = 0;
		rear = 0;
		count = 0;
	}

	public CircularArrayQueue() {
		elements = (E[]) new Object[3];
		front = 0;
		rear = 0;
		count = 0;
	}

	@Override
	public void enqueue(E element) {
		Objects.requireNonNull(element, "element is null");
		if (count == elements.length) {
			expandCapacity();
		}
		elements[rear] = element;
		rear = (rear + 1) % elements.length;
		count++;
	}

	private void expandCapacity() {
		E[] bigger = (E[]) new Object[elements.length << 1];
		for (int scan = 0; scan < count; scan++) {
			bigger[scan] = elements[front];
			front = (front + 1) % elements.length;
		}
		front = 0;
		rear = count;
		elements = bigger;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("the queue is null");
		}
		E result = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		count--;

		return result;
	}

	@Override
	public E first() {
		if (isEmpty()) {
			throw new NoSuchElementException("the queue is null");
		}

		return elements[front];
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
		return Arrays.deepToString(this.elements);
	}

	public static void main(String[] args) {
		Queue<String> queue = new CircularArrayQueue<>();
		queue.enqueue("a");
		System.out.println(queue.toString());
		queue.enqueue("b");
		System.out.println(queue.toString() + " ---- " + queue.size());
		queue.enqueue("c");
		System.out.println(queue.toString());

		System.out.println(queue.dequeue());
		System.out.println(queue.toString() + " ---- " + queue.size());

		System.out.println(queue.dequeue());
		System.out.println(queue.toString() + " ---- " + queue.size());

		queue.enqueue("d");
		System.out.println(queue.toString() + " ---- " + queue.size());
		queue.enqueue("e");
		System.out.println(queue.toString() + " ---- " + queue.size());


	}
}
