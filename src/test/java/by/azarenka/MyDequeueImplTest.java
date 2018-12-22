package by.azarenka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDequeueImplTest {

    private MyDequeue<String> myQueue = new MyDequeueImpl<String>();

    @Before
    public void testSetUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            myQueue.add(String.valueOf(i));
        }
    }

    @After
    public void testTearDown() throws Exception {
        for (int i = 0; i < myQueue.size(); i++) {
            myQueue.pop();
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

    @Test
    public void testAddFirst() {
        for (int i = 0; i < 100; i++) {
            myQueue.addFirst(String.valueOf(i));
            String eL = myQueue.getLast();
            assertThat(eL).isEqualTo("99");
            String eF = myQueue.getFirst();
            assertThat(eF).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void testAddLast() {
        testAdd();
    }

    @Test
    public void testGetFirst() {
        for (int i = 0; i < 99; i++) {
            String el = myQueue.getFirst();
            assertThat(el).isEqualTo(String.valueOf(i));
            myQueue.pop();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstNoElement() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        myQueue.getFirst();
    }

    @Test
    public void testGetLast() {
        String el = myQueue.getLast();
        assertThat(el).isEqualTo("99");
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastNoElement() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        myQueue.getLast();
    }

    @Test
    public void testOfferFirstIsTrue() {
        for (int i = 0; i < 100; i++) {
            boolean eL = myQueue.offerFirst(String.valueOf(i));
            assertThat(eL).isEqualTo(true);
        }
    }

    @Test
    public void testOfferFirst() {
        for (int i = 0; i < 100; i++) {
            myQueue.offerFirst(String.valueOf(i));
            String eL = myQueue.getFirst();
            assertThat(eL).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void testOfferFirstIsNull() {
        boolean eL = myQueue.offerFirst(null);
        assertThat(eL).isEqualTo(false);
    }

    @Test
    public void testOfferLastIsTrue() {
        for (int i = 0; i < 100; i++) {
            boolean eL = myQueue.offerFirst(String.valueOf(i));
            assertThat(eL).isEqualTo(true);
        }
    }

    @Test
    public void testOfferLastIsNull() {
        boolean eL = myQueue.offerFirst(null);
        assertThat(eL).isEqualTo(false);
    }

    @Test
    public void testPeekFirst() {
        String elem = myQueue.peekFirst();
        assertThat(elem).isEqualTo("0");
        assertThat(myQueue.size()).isEqualTo(100);
    }

    @Test
    public void testPeekFirstIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.peekFirst()).isEqualTo(null);
    }

    @Test
    public void testPeekLast() {
        String elem = myQueue.peekLast();
        assertThat(elem).isEqualTo("99");
        assertThat(myQueue.size()).isEqualTo(100);
    }

    @Test
    public void testPeekLastIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.peekLast()).isEqualTo(null);
    }

    @Test
    public void testPollFirst() {
        for (int i = 0; i < 100; i++) {
            String elem = myQueue.pollFirst();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void testPollFirstIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.pollFirst()).isEqualTo(null);
    }

    @Test
    public void testPollLast() {
        for (int i = 99; i >= 0; i--) {
            String elem = myQueue.pollLast();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void testPollLastIsNull() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        assertThat(myQueue.pollLast()).isEqualTo(null);
    }

    @Test
    public void testPop() {
        for (int i = 0; i < 100; i++) {
            String elem = myQueue.pop();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopNoElement() {
        for (int i = 0; i < 100; i++) {
            myQueue.removeFirst();
        }
        myQueue.pop();
    }

    @Test
    public void testPush() {
        for (int i = 0; i < 100; i++) {
            myQueue.push(String.valueOf(i));
            String eL = myQueue.getFirst();
            assertThat(eL).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void testRemoveFirst() {
        for (int i = 0; i < 100; i++) {
            String elem = myQueue.removeFirst();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstNoElement() {
        for (int i = 0; i < 101; i++) {
            myQueue.removeFirst();
        }
    }

    @Test
    public void testRemoveLast() {
        for (int i = 99; i >= 0; i--) {
            String elem = myQueue.removeLast();
            assertThat(elem).isEqualTo(String.valueOf(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastNoElement() {
        for (int i = 0; i < 101; i++) {
            myQueue.removeLast();
        }
    }

    @Test
    public void testIsEmpty() {
        for (int i = 0; i < 100; i++) {
            assertThat(myQueue.isEmpty()).isEqualTo(true);
            myQueue.removeLast();
        }
        assertThat(myQueue.isEmpty()).isEqualTo(false);
    }
}
