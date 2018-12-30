package by.azarenka;

import java.util.Comparator;

public interface MyTree {

    /**
     *Appends the binary element to the Tree.
     *
     * @param element
     * @return <code>true</code> else if this element  hasn't been added <code>false</code>
     */
    boolean add(Integer element);

    /**
     * Checks stack to exist  elements
     *
     * @return <code>true</code>
     */
    boolean isEmpty();

    /**
     * Removes element of this tree.
     *
     * @param value
     * @return
     */
    boolean delete(Integer value);

    /**
     * Returns array of elements
     *
     * @return
     */
    Object[] output();

    /**
     * Returns min value in this tree
     *
     * @return
     */
    int minValue();

    /**
     * Returns max value in this tree
     *
     * @return
     */
    int maxValue();

    /**
     * Searches for element
     *
     * @param value
     * @return if element is found <code>true</code> else <code>false</code>
     */
    boolean search(int value);
}
