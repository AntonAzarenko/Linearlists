package by.azarenka;

import java.util.EmptyStackException;

public interface MyStack<E> {
    /**
     * Checks stack to exist  elements
     *
     * @return <code>true</code> or if stack contains no items <code>false</code>
     */
    boolean isEmpty();

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param e the item to be pushed onto this stack.
     * @return e the <code>e</code>
     */
    E push(E e);

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return
     * @throws EmptyStackException
     */
    E peek();

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return
     * @throws EmptyStackException
     */
    E pop();

    /**
     * Returns size of stack.
     *
     * @return <code>integer</code>
     */
    int size();
}
