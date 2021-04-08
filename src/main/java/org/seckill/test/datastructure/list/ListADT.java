package org.seckill.test.datastructure.list;

import java.util.Iterator;

/**
 * @author cgm
 * @date 2021-04-07 10:41
 */
public interface ListADT<E> extends Iterable<E> {
    E removeFirst();

    E removeLast();

    E remove(E element);

    E first();

    E last();

    boolean contains(E target);

    boolean isEmpty();

    int size();

    /**
     * @return
     */
    @Override Iterator<E> iterator();

    /**
     * @return
     */
    @Override String toString();

}
