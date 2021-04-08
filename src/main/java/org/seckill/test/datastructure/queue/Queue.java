package org.seckill.test.datastructure.queue;

/**
 * @author cgm
 * @date 2021-04-06 15:11
 */
public interface Queue<E> {
	void enqueue(E element);

	E dequeue();

	E first();

	boolean isEmpty();

	int size();

	@Override
	String toString();
}
