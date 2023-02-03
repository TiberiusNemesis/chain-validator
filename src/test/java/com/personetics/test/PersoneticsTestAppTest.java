package com.personetics.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersoneticsTestAppTest {

    @Test
    void mainTest() {
        String[] args = new String[0];
        assertDoesNotThrow(() -> new PersoneticsTestApp().main(args));
    }
}