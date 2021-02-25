# Junit 

## Projects
* [Junit 4 custom test runner demo](https://github.com/rbhunia/junit/tree/master/junit4-custom-runner)
* [Junit 4 custom rules demo](https://github.com/rbhunia/junit/tree/master/junit4-rules)

## Notes

* Unit testing →  testing an unit in isolation from other units.
* They are programmers test
* Unit testing examines the behavior of a unit of work. 
* A unit of work is a task that doesn’t depend on other tasks.

* Test class can be a top level class or static nested class or inner class annotated with @Nested annotation. 
* Test class can’t be abstract and must have a single constructor. Single constructor can be no argument constructor or arguments that can be resolved dynamically at runtime.

+ Test method can be annotated with:
  - @Test
  - @RepeatedTest
  - @ParameterizedTest
  - @TestFactory
  - @TestTemplate

* If @Test annotated method returns a value, it will not be treated as a test method.
 
* To run junit 5 test cases, we need junit-jupiter-api and junit-jupiter-engine dependencies. 

+ Junit creates a new instance of a test class before invoking each @Test annotation methods.
  - to prevent unwanted side effects
  - test methods can be executed independently 

* If you annotate your test class with @TestInstance(Lifecycle.PER_CLASS) , JUnit 5 will execute all test methods on the same test instance. A new test instance will be created for each test class when using this annotation.

* @DisplayName annotation is used over class and method
* Used to declare a display name for test class and methods.

JUnit 4 was designed for developers , there was a single fat jar junit.jar
It was a monolithic architecture. Not modular.
Build tools like Maven and Gradle and IDEs like Eclipse NetBeans, Intellij they needed separate APIs. But there is only one fat Jar. They ended up using internals of Junit via reflection. Evolving Junit was very much difficult. 

Runners actually run your test cases.  
You can extend Runner abstract class and implement run method to write your own test execution logic. But involves heavy use of reflection. 

Junit rules intercept test method calls. 
Allows you to do something before the test method is run and something else after the test method has run. 

We can write a custom rule to add a new behavior before and after the test run.

We might like to start a process before executing a test and stop it after that, or connect to a database before executing a test and tear it down afterward.


