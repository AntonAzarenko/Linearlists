package by.azarenka;

public interface MyQueue<E> {
    /**
     * Appends the specified element to the end of this Queue.
     *
     * @param e the element append into this queue.
     * @return <code>true</code> if element don't apended<code>false</code>
     */
    boolean add(E e);

    /**
     * Appends the specified element to the end of this Queue
     *
     * @param e the element append into this queue.
     * @return <code>true</code> if element don't apended<code>false</code>
     */
    boolean offer(E e);

    /**
     * Removes the element end return his
     *
     * @return element <code>E</code>
     */
    E remove();

    /**
     * Returns first element in this queue without remove.
     *
     * @return <code>E</code>
     * @throws java.util.NoSuchElementException if size equals 0
     */
    E element();

    /**
     * Returns first element  in this queue without remove.
     *
     * @return if size equals 0 <code>null<code/> else <code>E</code>
     */
    E peek();

    /**
     * Returns first element  in this queue and remove his.
     *
     * @return if size equals 0 <code>null</code> else <code>E</code>
     */
    E poll();

    /**
     * Returns size this queue.
     *
     * @return <code>integer</code>
     */
    int size();
}
