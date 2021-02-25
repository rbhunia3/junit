package com.example;

import org.junit.Rule;
import org.junit.Test;

public class CustomRuleTester {

    @Rule
    public CustomRule customRule = new CustomRule();

    @Test
    public void myCustomTestRules() {
        System.out.println("Call of a test method");
    }
}
