package com.example;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRule implements TestRule {

    private Statement base;
    private Description description;


    @Override
    public Statement apply(Statement base, Description description) {
        this.description = description;
        this.base = base;
        return new CustomStatement(base, description);
    }
}
