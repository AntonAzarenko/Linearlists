package by.azarenka;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStackImpl<E> implements MyStack<E> {

    private Object[] elements;

    private int size = 0;

    private int capasity = 12;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E push(E e) {
        if(elements == null){
            elements = new Object[capasity];
        }if(elements.length >=size){
            capasityUp(size + 1);
        }
        elements[size] = e;
        size++;
        return e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if(size == 0){
            throw new EmptyStackException();
        }
        return (E) elements[size - 1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if(size == 0){
            throw new EmptyStackException();
        }
        E tempElement = (E) elements[size-1];
        elements[size-1] = null;
        size--;
        return tempElement;
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
}
