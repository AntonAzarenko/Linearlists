package by.azarenka;

public interface MyQueue<E>{

    boolean add(E e);

    boolean offer(E e);

    E remove();

    E element();

    E peek();

    E poll();

    int size();


}
