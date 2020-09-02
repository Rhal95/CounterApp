package de.rhal.fx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterButtonTest {
    @Test
    void countUp() {
        CounterButton sut = new CounterButton("TestButton", 2, false);

        assertEquals("TestButton\n0/2 (0%)", sut.getText());
        sut.fire();
        assertEquals("TestButton\n1/2 (50%)", sut.getText());
        sut.fire();
        assertEquals("TestButton\n2/2 (100%)", sut.getText());
    }

    @Test
    void countDown() {
        CounterButton sut = new CounterButton("TestButton", 2, true);

        assertEquals("TestButton\n2/2 (0%)", sut.getText());
        sut.fire();
        assertEquals("TestButton\n1/2 (50%)", sut.getText());
        sut.fire();
        assertEquals("TestButton\n0/2 (100%)", sut.getText());
    }
}
