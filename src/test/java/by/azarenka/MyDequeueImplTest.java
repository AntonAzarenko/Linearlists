package by.azarenka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;


public class MyDequeueImplTest {

    private MyDequeue<String> myQueue = new MyDequeueImpl<String>();

    private static final Logger log = LoggerFactory.getLogger(MyDequeueImplTest.class);

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            myQueue.add(String.valueOf(i));
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < myQueue.size(); i++) {
            myQueue.pop();
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

    @Test
    public void addFirst() {
        for (int i = 0; i < 100; i++) {
            myQueue.addFirst(String.valueOf(i));
            String eL = myQueue.getLast();
            assertThat(eL).isEqualTo("99");
            String eF = myQueue.getFirst();
            assertThat(eF).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void addLast() {
        add();
    }

    @Test
    public void getFirst() {
        for (int i = 0; i < 99; i++) {
            String el = myQueue.getFirst();
            assertThat(el).isEqualTo(String.valueOf(i));
            myQueue.pop();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void getFirstNoElement() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        myQueue.getFirst();
    }

    @Test
    public void getLast() {
        String el = myQueue.getLast();
        assertThat(el).isEqualTo("99");
    }

    @Test(expected = NoSuchElementException.class)
    public void getLastNoElement() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        myQueue.getLast();
    }

    @Test
    public void offerFirstIsTrue() {
        for (int i = 0; i < 100; i++) {
            boolean eL = myQueue.offerFirst(String.valueOf(i));
            assertThat(eL).isEqualTo(true);
        }
    }

    @Test
    public void offerFirst() {
        for (int i = 0; i < 100; i++) {
            myQueue.offerFirst(String.valueOf(i));
            String eL = myQueue.getFirst();
            assertThat(eL).isEqualTo(String.valueOf(i));
        }
    }

    @Test()
    public void offerFirstIsNull() {
        boolean eL = myQueue.offerFirst(null);
        assertThat(eL).isEqualTo(false);
    }

    @Test
    public void offerLastIsTrue() {
        for (int i = 0; i < 100; i++) {
            boolean eL = myQueue.offerFirst(String.valueOf(i));
            assertThat(eL).isEqualTo(true);
        }
    }

    @Test
    public void offerLastIsNull() {
        boolean eL = myQueue.offerFirst(null);
        assertThat(eL).isEqualTo(false);
    }

    @Test
    public void peekFirst() {
        String elem = myQueue.peekFirst();
        assertThat(elem).isEqualTo("0");
        assertThat(myQueue.size()).isEqualTo(100);
    }

    @Test
    public void peekFirstIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.peekFirst()).isEqualTo(null);
    }

    @Test
    public void peekLast() {
        String elem = myQueue.peekLast();
        assertThat(elem).isEqualTo("99");
        assertThat(myQueue.size()).isEqualTo(100);
    }

    @Test
    public void peekLastIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.peekLast()).isEqualTo(null);
    }

    @Test
    public void pollFirst() {
        for (int i = 0; i < 100; i++) {
            String elem = myQueue.pollFirst();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void pollFirstIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.pollFirst()).isEqualTo(null);
    }

    @Test
    public void pollLast() {
        for (int i = 99; i >= 0; i--) {
            String elem = myQueue.pollLast();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void pollLastIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.pollLast()).isEqualTo(null);
    }

    @Test
    public void pop() {
        for (int i = 0; i < 100; i++) {
            String elem = myQueue.pop();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void popNoElement() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        myQueue.pop();
    }

    @Test
    public void push() {
        for (int i = 0; i < 100; i++) {
            myQueue.push(String.valueOf(i));
            String eL = myQueue.getFirst();
            assertThat(eL).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void removeFirst() {
        for (int i = 0; i < 100; i++) {
            String elem = myQueue.removeFirst();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstNoElement() {
        for (int i = 0; i < 101; i++) {
            myQueue.removeFirst();
        }
    }

    @Test
    public void removeLast() {
        for (int i = 99; i >= 0; i--) {
            String elem = myQueue.removeLast();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastNoElement() {
        for (int i = 0; i < 101; i++) {
            myQueue.removeLast();
        }
    }

    @Test
    public void isEmpty(){
        for (int i = 0; i < 100; i++) {
            assertThat(myQueue.isEmpty()).isEqualTo(true);
            myQueue.removeLast();
        }
        assertThat(myQueue.isEmpty()).isEqualTo(false);
    }
}
