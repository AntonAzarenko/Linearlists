package by.azarenka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyQueueImplTest {

    private MyQueue<String> myQueue = new MyQueueImpl<String>();

    @Before
    public void testSetUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            myQueue.add(String.valueOf(i));
        }
    }

    @After
    public void testTearDown() throws Exception {
        for (int i = 0; i < 100; i++) {
            myQueue.poll();
        }
    }

    @Test
    public void testAdd() {
        int size = 100;
        for (int i = 0; i < 100; i++) {
            if (myQueue.add(String.valueOf(i))) {
                size++;
            }
        }
        assertThat(myQueue.size()).isEqualTo(size);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullPointerException() {
        myQueue.add(null);
    }

    @Test
    public void testOffer() {
        int size = 100;
        for (int i = 0; i < 100; i++) {
            if (myQueue.add(String.valueOf(i))) {
                size++;
            }
        }
        assertThat(myQueue.size()).isEqualTo(size);
    }

    @Test
    public void testRemove() {
        myQueue.remove();
        assertThat(myQueue.size()).isEqualTo(99);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNoSuchElemetExpetion() {
        for (int i = 0; i < 101; i++) {
            myQueue.remove();
        }
        assertThat(myQueue.size()).isEqualTo(0);
    }

    @Test
    public void testElement() {
        String elem = myQueue.element();
        assertThat(elem).isEqualTo("0");
        assertThat(myQueue.size()).isEqualTo(100);
        myQueue.poll();
        elem = myQueue.element();
        assertThat(elem).isEqualTo("1");
        assertThat(myQueue.size()).isEqualTo(99);
    }

    @Test(expected = NoSuchElementException.class)
    public void testElementNoSuchElementException() {
        for (int i = 0; i < 100; i++) {
            myQueue.remove();
        }
        myQueue.element();
    }

    @Test
    public void testPeek() {
        String elem = myQueue.peek();
        assertThat(elem).isEqualTo("0");
        assertThat(myQueue.size()).isEqualTo(100);
    }

    @Test
    public void testPoll() {
        int size = 100;
        for (int i = 0; i < 100; i++) {
            String element = myQueue.poll();
            assertThat(element).isEqualTo(String.valueOf(i));
            assertThat(myQueue.size()).isEqualTo(--size);
        }
    }
}
