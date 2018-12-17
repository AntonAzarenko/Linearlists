package by.azarenka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyQueueImplTest {

    private MyQueue<String> myQueue = new MyQueueImpl<String>();

    private static final Logger log = LoggerFactory.getLogger(MyQueueImplTest.class);

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            myQueue.add(String.valueOf(i));
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < 100; i++) {
            myQueue.poll();
        }
    }

    @Test
    public void add() {
        int size = 100;
        for (int i = 0; i < 100; i++) {
            if (myQueue.add(String.valueOf(i))) {
                size++;
            }
        }
        assertThat(myQueue.size()).isEqualTo(size);
    }

    @Test(expected = NullPointerException.class)
    public void addNullPointerException() {
       myQueue.add(null);
    }

    @Test
    public void offer() {
        int size = 100;
        for (int i = 0; i < 100; i++) {
            if (myQueue.add(String.valueOf(i))) {
                size++;
            }
        }
        assertThat(myQueue.size()).isEqualTo(size);
    }

    @Test
    public void remove() {
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
    public void element() {
        String elem = myQueue.element();
        assertThat(elem).isEqualTo("0");
        assertThat(myQueue.size()).isEqualTo(100);
        myQueue.poll();
        elem = myQueue.element();
        assertThat(elem).isEqualTo("1");
        assertThat(myQueue.size()).isEqualTo(99);
    }

    @Test(expected = NoSuchElementException.class)
    public void elementNoSuchElementException() {
        for (int i = 0; i < 100; i++) {
            myQueue.remove();
        }
        String elem = myQueue.element();
    }

    @Test
    public void peek() {
        String elem = myQueue.peek();
        assertThat(elem).isEqualTo("0");
        assertThat(myQueue.size()).isEqualTo(100);
    }

    @Test
    public void poll() {
        int size = 100;
        for(int i = 0; i < 100; i++){
            String element = myQueue.poll();
            assertThat(element).isEqualTo(String.valueOf(i));
            assertThat(myQueue.size()).isEqualTo(--size);
        }
    }
}
