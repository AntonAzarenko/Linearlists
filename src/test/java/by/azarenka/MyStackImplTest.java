package by.azarenka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStackImplTest {

    private MyStack<String> myStack = new MyStackImpl<String>();

    private static final Logger log = LoggerFactory.getLogger(MyStackImplTest.class);

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            myStack.push(String.valueOf(i));
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < myStack.size(); i++) {
            myStack.pop();
        }
    }

    @Test
    public void isEmpty() {
        for (int i = 0; i < 100; i++) {
            assertThat(myStack.isEmpty()).isEqualTo(false);
            myStack.pop();
        }
        assertThat(myStack.isEmpty()).isEqualTo(true);

    }

    @Test
    public void push() {
        for (int i = 0; i < 100; i++) {
            assertThat(myStack.size()).isEqualTo(100 + i);
            myStack.push(String.valueOf(i));
        }
        assertThat(myStack.peek()).isEqualTo(String.valueOf(99));
    }

    @Test
    public void peek() {
        assertThat(myStack.peek()).isEqualTo(String.valueOf(99));
    }

    @Test(expected = EmptyStackException.class)
    public void peekNoElement() {
        for (int i = 0; i < 100; i++) {
            myStack.pop();
        }
        myStack.peek();
    }

    @Test
    public void pop() {
        int size = myStack.size();
        log.info(String.valueOf(size));
        assertThat(myStack.pop()).isEqualTo(String.valueOf(99));
        size = size - 1;
        assertThat(size).isEqualTo(size);
    }

    @Test(expected = EmptyStackException.class)
    public void popNoElement() {
        for (int i = 0; i < 100; i++) {
            myStack.pop();
        }
        myStack.pop();
    }
}
