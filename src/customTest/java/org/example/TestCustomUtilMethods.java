package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomUtilMethods {

    @Test
    public void doTest() {
        assertEquals("HiING", Utils.addSuffix("Hi"));
        assertEquals("HiCUSTOM_TEST", CustomTestUtils.addCustomTestSuffix("Hi"));
    }

}
