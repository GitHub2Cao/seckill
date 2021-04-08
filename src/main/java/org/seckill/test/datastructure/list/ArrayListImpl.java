package org.seckill.test.datastructure.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author cgm
 * @date 2021-04-07 12:37
 */
public abstract class ArrayListImpl<E> implements ListADT<E> {
	protected int rear;
	protected E[] elements;

	protected final static int NOT_FOUND = -1;

	public ArrayListImpl() {
		this(3);
	}

	public ArrayListImpl(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException("initialCapacity must bigger then 0");
		}
		this.rear = 0;
		this.elements = (E[]) new Object[initialCapacity];
	}

	@Override
	public E removeFirst() {
		emptyThrow();
		E result = elements[rear - 1];
		elements[rear - 1] = null;
		rear--;
		return result;
	}

	@Override
	public E removeLast() {
		emptyThrow();
		E result = elements[0];
		for (int i = 0; i < rear; i++) {
			elements[i] = elements[i + 1];
		}
		rear--;
		return result;
	}

	@Override
	public E remove(E element) {
		Objects.requireNonNull(element, "element is null");
		emptyThrow();
		int index = find(element);
		if (index == NOT_FOUND) {
			throw new NoSuchElementException("not such element find " + element);
		}
		for (int i = index; i < rear; i++) {
			elements[i] = elements[i + 1];
		}
		rear--;
		return element;
	}

	@Override
	public E first() {
		emptyThrow();
		return elements[rear - 1];
	}

	@Override
	public E last() {
		emptyThrow();
		return elements[0];
	}

	@Override
	public boolean contains(E target) {
		emptyThrow();
		return find(target) != NOT_FOUND;
	}

	protected int find(E target) {
		for (int i = 0; i < rear; i++) {
			if (elements[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return rear == 0;
	}

	@Override
	public int size() {
		return rear;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public String toString() {
		return Arrays.deepToString(this.elements);
	}

	private void emptyThrow() {
		if (isEmpty()) {
			throw new NoSuchElementException("the list is null");
		}
	}
}
