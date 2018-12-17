package by.azarenka;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueueImpl<E> implements MyQueue<E> {

    public MyQueueImpl() {
    }

    public MyQueueImpl(int capasity) {
        this.capasity = capasity;
    }

    private int capasity = 16;

    private Object[] elements;

    private int size = 0;

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        if (elements == null) {
            elements = new Object[capasity];
        }
        if (e == null) {
            throw new NullPointerException();
        }
        if (size >= elements.length) {
            capasityUp(size + 1);
        }
        if (size == 0) {
            elements[0] = e;
        } else {
            elements[size] = e;
        }
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

    private void capasityUp(int capasity) {
        int oldSize = elements.length;
        int newSize = oldSize + (oldSize >= 2 ? capasity / 2 : capasity);
        elements = Arrays.copyOf(elements, newSize);
    }

    private void moveLeft() {
        int s = elements.length;
        Object[] tempory = new Object[s];

        System.arraycopy(elements, 1, tempory, 0, s - 2);
        size--;
        elements = tempory;
    }
}
