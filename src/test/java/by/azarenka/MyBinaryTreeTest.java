package by.azarenka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyBinaryTreeTest {

    private MyTree tree;

    @Before
    public void before() {
        tree = new MyBinaryTree();
    }

    @After
    public void after() {
        tree = null;
    }

    @Test
    public void testAdd() {
        tree.add(50);
        assertThat(true).isEqualTo(tree.search(50));
    }

    @Test
    public void testAddIsFalse() {
        tree = new MyBinaryTree();
        assertThat(false).isEqualTo(tree.search(80));
    }

    @Test
    public void testAddIsContains() {
        tree.add(50);
        assertThat(false).isEqualTo(tree.add(50));
    }

    @Test(expected = NullPointerException.class)
    public void testAddIsNull() {
        tree.add(null);
    }

    @Test
    public void testIsEmpty() {
        tree.add(50);
        assertThat(true).isEqualTo(tree.isEmpty());
    }

    @Test
    public void testDelete() {
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        assertThat(true).isEqualTo(tree.delete(40));
        assertThat(false).isEqualTo(tree.search(40));
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteIsNull() {
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        tree.delete(null);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteIfTreeEmpty() {
        tree.delete(55);
    }

    @Test
    public void testMinValue() {
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        int min = tree.minValue();
        assertThat(min).isEqualTo(40);
    }

    @Test(expected = NullPointerException.class)
    public void testMinValueIfTreeIsEmpty() {
        tree.minValue();
    }

    @Test
    public void testMaxValue() {
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        int min = tree.maxValue();
        assertThat(min).isEqualTo(55);
    }

    @Test(expected = NullPointerException.class)
    public void testMaxValueIfTreeIsEmpty() {
        tree.maxValue();
    }

    @Test
    public void search() {
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        assertThat(true).isEqualTo(tree.search(60));
    }

    @Test
    public void searchIfNumberAbsent() {
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        assertThat(false).isEqualTo(tree.search(70));
    }

    @Test
    public void testOutput() {
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        Object[] objects = tree.output();
        for (Object current : objects) {
            System.out.println(current.toString());
        }
    }
}
