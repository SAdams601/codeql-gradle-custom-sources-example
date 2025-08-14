package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilMethods {

    @Test
    public void doTest() {
        assertEquals("HiING", Utils.addSuffix("Hi"));
        assertEquals("HiTEST", TestUtils.addTestSuffix("Hi"));
    }

}
