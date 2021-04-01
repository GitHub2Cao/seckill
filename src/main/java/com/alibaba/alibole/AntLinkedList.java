package com.alibaba.alibole;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author cgm
 * @date 2021-03-18 14:22
 * //评测题目:
 * //1、用java代码实现LinkedList的add()和remove()方法。要求自行设计LinkedList数据结构，不要外部类库和辅助函数来处理。
 */
public class AntLinkedList<T> {

	private Node<T> first;

	private Node<T> last;

	private int size;


	/**
	 * 如果index超出队列长度就加到队列最后.
	 */
	public boolean add(int index, T element) {
		if (index < 0) {
			throw new IllegalArgumentException("index is less then 0");
		}

		Node<T> current = first;
		if (index == 0) {
			return addFirst(element);
		} else if (index >= size) {
			addLast(element);
		} else {
			// 双向队列可以优化一下顺序
			for (int i = 0; i < index - 1; i++) {
				current = first.getNext();
			}
			Node<T> newNode = new Node<>(current, current.getNext(), element);
			current.getNext().setPrev(newNode);
			current.setNext(newNode);

			size++;
		}
		return true;

	}

	public boolean addLast(T element) {
		Node newNode = new Node(last, null, element);
		if (first == null) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		size++;
		return true;
	}

	public boolean addFirst(T element) {
		Node<T> newNode = new Node<>(null, first, element);
		if (first == null) {
			last = newNode;
		} else {
			newNode.setNext(first);
			first.setPrev(newNode);
		}
		first = newNode;
		size++;

		return true;
	}

	public T removeFirst() {
		if (size <= 1) {
			throw new NoSuchElementException("the list is empty");
		}
		T element = (T) first.getObj();
		first = first.getNext();
		if (first == null) {
			last = null;
		} else {
			first.prev = null;
		}
		size--;
		return element;
	}

	public T removeLast() {
		if (size <= 1) {
			throw new NoSuchElementException("the list is empty");
		}
		T element = (T) last.getObj();
		last = last.getPrev();
		if (last == null) {
			first = null;
		} else {
			last.setNext(null);
		}
		size--;
		return element;
	}

	/**
	 * 如果index超出队列长度就删除队列最后.
	 *
	 * @param index
	 * @return
	 */
	public T remove(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("index is less then 0");
		}
		if (size <= 0) {
			throw new NoSuchElementException("the list is empty");
		}
		if (index == 0) {
			return removeFirst();
		} else if (index > size) {
			return removeLast();
		} else {
			Node<T> current = first;
			// 双向队列可以优化一下顺序
			for (int i = 0; i <= index - 1; i++) {
				current = first.getNext();
			}
			T element = current.getObj();
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
			size--;
			return element;
		}
	}

	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node<T> x = first; x != null; x = x.next) {
			result[i++] = x.getObj();
		}
		return result;

	}

	public static void main(String[] args) {
		AntLinkedList<String> antLinkedList = new AntLinkedList<>();
		antLinkedList.addFirst("a");
		antLinkedList.addFirst("b");
		antLinkedList.addFirst("c");
		antLinkedList.addFirst(null);
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println(antLinkedList.removeFirst());
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println("-------------");
		antLinkedList = new AntLinkedList<>();
		antLinkedList.addLast("a");
		antLinkedList.addLast("b");
		antLinkedList.addLast("c");
		antLinkedList.addLast(null);
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println(antLinkedList.removeFirst());
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println("-------------");
		antLinkedList = new AntLinkedList<>();
		antLinkedList.addFirst("a");
		antLinkedList.addFirst("b");
		antLinkedList.addFirst("c");
		antLinkedList.addFirst(null);
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println(antLinkedList.removeLast());
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println("-------------");
		antLinkedList = new AntLinkedList<>();
		antLinkedList.add(0, "a");
		antLinkedList.add(1, "b");
		antLinkedList.add(2, "c");
		antLinkedList.add(1, "bb");
		antLinkedList.add(2, "bbb");
		antLinkedList.add(2, "bbbb");
		antLinkedList.add(20, "bbbb");
		antLinkedList.add(1, null);
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println(antLinkedList.remove(0));
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println(antLinkedList.remove(10));
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
		System.out.println(antLinkedList.remove(1));
		System.out.println(Arrays.deepToString(antLinkedList.toArray()));
	}


	private class Node<T> {
		private Node<T> prev;
		private Node<T> next;
		private T obj;

		public Node(Node<T> prev, Node<T> next, T obj) {
			this.prev = prev;
			this.next = next;
			this.obj = obj;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getObj() {
			return obj;
		}

		public void setObj(T obj) {
			this.obj = obj;
		}
	}

}
