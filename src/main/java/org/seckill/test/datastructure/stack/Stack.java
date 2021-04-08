package org.seckill.test.datastructure.stack;

/**
 * @author cgm
 * @create 2021-04-06 12:41
 */
public interface Stack<E> {
	void push(E element);

	E pop();

	E peek();

	boolean isEmpty();

	int size();

	@Override
	String toString();
}
