package by.azarenka;

public interface MyDequeue<E> {

    /**
     * Appends the specified element to the end of this Queue.
     *
     * @param e the element append into this queue.
     * @return <code>true</code> if element don't apended<code>false</code>
     */
    boolean add(E e);

    /**
     * Appends the specified element to the start of this Queue.
     *
     * @param obj the element append into this queue.
     * @return <code>true</code> if element don't apended<code>false</code>
     */
    void addFirst(E obj);

    /**
     * Appends the specified element to the end of this Queue.
     *
     * @param obj the element append into this queue.
     * @return <code>true</code> if element don't apended<code>false</code>
     */
    void addLast(E obj);

    /**
     * Returns first element in this queue without remove. If this queue is empty generates excepion.
     *
     * @return <code>obj<code/>
     * @throws java.util.NoSuchElementException
     */
    E getFirst();

    /**
     * Returns last element in this queue without remove. If this queue is empty generates excepion.
     *
     * @return <code>obj<code/>
     * @throws java.util.NoSuchElementException
     */
    E getLast();

    /**
     * Appends the specified element to the start of this Queue.
     *
     * @param obj the element append into this queue.
     * @return <code>true</code> if element don't apended<code>false</code>
     */
    boolean offerFirst(E obj);

    /**
     * Appends the specified element to the end of this Queue.
     *
     * @param obj the element append into this queue.
     * @return <code>true</code> if element don't apended<code>false</code>
     */
    boolean offerLast(E obj);

    /**
     * Returns first element in this queue without remove.
     *
     * @return if size equals 0 <code>null<code/> else <code>E</code>
     */
    E peekFirst();

    /**
     * Returns end element in this queue without remove.
     *
     * @return if size equals 0 <code>null<code/> else <code>E</code>
     */
    E peekLast();

    /**
     * Returns first element in this queue and remove his.
     *
     * @return if size equals 0 <code>null</code> else <code>E</code>
     */
    E pollFirst();

    /**
     * Returns last element in this queue and remove his.
     *
     * @return if size equals 0 <code>null</code> else <code>E</code>
     */
    E pollLast();

    /**
     * Returns first element  in this queue and remove his. If this queue is empty generates excepion.
     *
     * @return <code>E</code>
     * @throws java.util.NoSuchElementException
     */
    E pop();

    /**
     * Appends the specified element to the end of this Queue.
     *
     * @param element the element append into this queue.
     * @return <code>element</code>
     */
    void push(E element);

    /**
     * Returns first element  in this queue and remove his. If this queue is empty generates excepion.
     *
     * @return <code>E</code>
     * @throws java.util.NoSuchElementException
     */
    E removeFirst();

    /**
     * Returns last element  in this queue and remove his. If this queue is empty generates excepion.
     *
     * @return <code>E</code>
     * @throws java.util.NoSuchElementException
     */
    E removeLast();

    /**
     * Returns size this queue.
     *
     * @return <code>integer</code>
     */
    int size();

    /**
     * Checks stack to exist  elements
     *
     * @return <code>true</code> or if stack contains no items <code>false</code>
     */
    boolean isEmpty();
}
