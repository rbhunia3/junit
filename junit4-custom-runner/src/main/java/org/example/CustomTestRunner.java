package org.example;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomTestRunner extends Runner {

    private Class<?> classToTest;

    public CustomTestRunner(Class<?> classToTest) {
        this.classToTest = classToTest;
    }

    @Override
    public Description getDescription() {
        return Description.createTestDescription(classToTest,
                this.getClass().getSimpleName() + " description.");
    }

    @Override
    public void run(RunNotifier notifier) {
        System.out.println("Running tests with " +
                this.getClass().getSimpleName() + ": " + classToTest);

        try {
            Object testObject = classToTest.newInstance();
            for (Method method : classToTest.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    notifier.fireTestStarted(Description
                            .createTestDescription(classToTest,
                                    method.getName()));

                    method.invoke(testObject);

                    notifier.fireTestFinished(Description
                            .createTestDescription(classToTest,
                                    method.getName()));
                }
            }
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
