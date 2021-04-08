package org.seckill.test.datastructure.queue;

import java.util.NoSuchElementException;

/**
 * @author cgm
 * @create 2021-04-06 19:24
 */
public class LinkedQueue<E> implements Queue<E> {
    private int count;

    private LinearNode<E> head;
    private LinearNode<E> tail;

    public LinkedQueue() {
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    @Override public void enqueue(E element) {
        LinearNode<E> node = new LinearNode<>(element);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        count++;
    }

    @Override public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("the queue is null");
        }
        E result = head.getElement();
        // head = tail
        if (count == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        count--;
        return result;
    }

    @Override public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("the queue is null");
        }
        return head.element;
    }

    @Override public boolean isEmpty() {
        return count == 0;
    }

    @Override public int size() {
        return count;
    }

    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", ");
        LinearNode<E> tempHead = head;
        while (tempHead != null) {
            stringBuilder.append(tempHead.getElement()).append(", ");
            tempHead = tempHead.getNext();
            if (tempHead == null) {
                break;
            }
        }
        return stringBuilder.toString().replaceFirst(", ", "");
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedQueue<>();
        queue.enqueue("a");
        System.out.println(queue.toString());
        queue.enqueue("b");
        System.out.println(queue.toString());
        queue.enqueue("c");
        System.out.println(queue.toString());
        queue.enqueue("d");
        System.out.println(queue.toString());

        System.out.println(queue.dequeue());
        System.out.println(queue.toString());

        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
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
