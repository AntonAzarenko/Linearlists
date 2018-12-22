package by.azarenka;

import java.util.NoSuchElementException;

public class MyDequeueImpl<E> implements MyDequeue<E> {

    private Object[] elements;

    private int size = 0;

    private int capacity = 12;

    public MyDequeueImpl() {
    }

    public MyDequeueImpl(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(E e) {
        return offerLast(e);
    }

    @Override
    public void addFirst(E e) {
        if (elements == null) {
            elements = new Object[capacity];
        }
        if (size >= elements.length) {
            capacityUp(size + 1);
        }
        if (size == 0) {
            elements[0] = e;
        } else {
            moveRight();
            elements[0] = e;
        }
        size = size + 1;
    }

    @Override
    public void addLast(E e) {
        offerLast(e);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getFirst() {
        if (size == 0) throw new NoSuchElementException();
        return (E) elements[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getLast() {
        if (size == 0) throw new NoSuchElementException();
        return (E) elements[size - 1];
    }

    @Override
    public boolean offerFirst(E e) {
        if (e == null) {
            return false;
        }
        if (elements == null) {
            elements = new Object[capacity];
        }
        if (size >= elements.length) {
            capacityUp(size + 1);
        }
        if (size == 0) {
            elements[0] = e;
        } else {
            moveRight();
            elements[0] = e;
        }
        size = size + 1;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (e == null) {
            return false;
        }
        if (elements == null) {
            elements = new Object[capacity];
        }
        if (size >= elements.length) {
            capacityUp(size + 1);
        }
        if (size == 0) {
            elements[0] = e;
        } else {
            elements[size] = e;
        }
        size = size + 1;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peekFirst() {
        if (size == 0) {
            return null;
        }
        return (E) elements[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peekLast() {
        if (size == 0) {
            return null;
        }
        return (E) elements[size - 1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pollFirst() {
        if (size == 0) {
            return null;
        }
        E element = (E) elements[0];
        moveLeft();
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pollLast() {
        if (size == 0) {
            return null;
        }
        E element = (E) elements[size - 1];
        elements[--size] = null;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[0];
        moveLeft();
        return element;
    }

    @Override
    public void push(E element) {
        offerFirst(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[0];
        moveLeft();
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[size - 1];
        elements[--size] = null;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    private void capacityUp(int capacity) {
        int oldSize = elements.length;
        int newSize = oldSize + (oldSize >= 2 ? capacity / 2 : capacity);
        Object[] temper = new Object[newSize];
        for (int i = 0; i < size; i++) {
            temper[i] = elements[i];
        }
        elements = temper;
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

    private void moveRight() {
        int s = elements.length;
        Object[] temper = new Object[s];
        for (int i = 0; i < size; i++) {
            temper[i + 1] = elements[i];
        }
        elements = temper;
    }
}
