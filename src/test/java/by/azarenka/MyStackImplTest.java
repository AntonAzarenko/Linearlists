package by.azarenka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStackImplTest {

    private MyStack<String> myStack = new MyStackImpl<String>();

    @Before
    public void testSetUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            myStack.push(String.valueOf(i));
        }
    }

    @After
    public void testTearDown() throws Exception {
        for (int i = 0; i < myStack.size(); i++) {
            myStack.pop();
        }
    }

    @Test
    public void testIsEmpty() {
        for (int i = 0; i < 100; i++) {
            assertThat(myStack.isEmpty()).isEqualTo(false);
            myStack.pop();
        }
        assertThat(myStack.isEmpty()).isEqualTo(true);
    }

    @Test
    public void testPush() {
        for (int i = 0; i < 100; i++) {
            assertThat(myStack.size()).isEqualTo(100 + i);
            myStack.push(String.valueOf(i));
        }
        assertThat(myStack.peek()).isEqualTo(String.valueOf(99));
    }

    @Test
    public void testPeek() {
        assertThat(myStack.peek()).isEqualTo(String.valueOf(99));
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekNoElement() {
        for (int i = 0; i < 100; i++) {
            myStack.pop();
        }
        myStack.peek();
    }

    @Test
    public void testPop() {
        int size = myStack.size();
        assertThat(myStack.pop()).isEqualTo(String.valueOf(99));
        size = size - 1;
        assertThat(size).isEqualTo(size);
    }

    @Test(expected = EmptyStackException.class)
    public void testPopNoElement() {
        for (int i = 0; i < 100; i++) {
            myStack.pop();
        }
        myStack.pop();
    }
}
