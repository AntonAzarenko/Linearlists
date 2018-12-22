package by.azarenka;

import java.util.NoSuchElementException;

public class MyQueueImpl<E> implements MyQueue<E> {

    public MyQueueImpl() {
    }

    public MyQueueImpl(int capacity) {
        this.capacity = capacity;
    }

    private int capacity = 16;

    private Object[] elements;

    private int size = 0;

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        if (elements == null) {
            elements = new Object[capacity];
        }
        if (e == null) {
            throw new NullPointerException();
        }
        if (size >= elements.length) {
            capacityUp(size + 1);
        }
        elements[size] = e;
        size = size + 1;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[0];
        moveLeft();
        return element;
    }

    @SuppressWarnings("unchecked")
    public E element() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (E) elements[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (size == 0) {
            return null;
        }
        return (E) elements[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0) {
            return null;
        }
        E element = (E) elements[0];
        moveLeft();
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    private void capacityUp(int capacity) {
        int oldSize = elements.length;
        int newSize = oldSize + (oldSize >= 2 ? capacity / 2 : capacity);
        Object[] temp = new Object[newSize];
        System.arraycopy(elements, 0, temp, 0, size);
        elements = temp;
    }

    private void moveLeft() {
        int s = elements.length;
        Object[] temper = new Object[s];
        for (int i = 0; i < size; i++) {
            temper[i] = elements[i + 1];
        }
        size--;
        elements = temper;
    }
}
