package de.rhal.fx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterTest {


    @Test
    void countUp() {
        Counter sut = new Counter("TestButton", 2, false);

        assertEquals("TestButton\n0/2 (0%)", sut.text.get());
        sut.count();
        assertEquals("TestButton\n1/2 (50%)", sut.text.get());
        sut.count();
        assertEquals("TestButton\n2/2 (100%)", sut.text.get());
    }

    @Test
    void countDown() {
        Counter sut = new Counter("TestButton", 2, true);

        assertEquals("TestButton\n2 (0%)", sut.text.get());
        sut.count();
        assertEquals("TestButton\n1 (50%)", sut.text.get());
        sut.count();
        assertEquals("TestButton\n0 (100%)", sut.text.get());
    }
}
