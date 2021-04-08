package org.seckill.test.datastructure.list;

/**
 * @author cgm
 * @create 2021-04-07 10:47
 */
public interface UnorderedListADT<E> extends ListADT<E> {
	void add2Front(E element);

	void add2Rear(E element);

	void addAfter(E element, E target);

	void addBefore(E element, E target);
}
