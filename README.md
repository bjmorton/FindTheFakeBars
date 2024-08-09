FindFakeBars
This is a test automation framework using Java, Selenium, and Cucumber for BDD (Behavior-Driven Development).
The framework is designed to use the scale tool provided and isolate the "gold bar" that weighs less than its counterparts.

Project Structure
FindFakeBars/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/brian/findfakebars/
│   │   │       └── App.java
│   │   └── test/
│   │       ├── java/
│   │       │   └── com/brian/findfakebars/
│   │       │       └── stepdefs/
│   │       │           └── CukesRunner.java
│   │       └── resources/
│   │           └── features/
│   │               └── find_fake_gold_bar.feature
│   └── test/
│       └── java/
│           └── com/brian/findfakebars/
│               └── stepdefs/
│                   └── FindFakeGoldBarSteps.java
└── pom.xml

Dependencies
The project uses the following dependencies:

Selenium Java: org.seleniumhq.selenium:selenium-java:4.18.1
Cucumber JUnit: io.cucumber:cucumber-junit:7.3.2
Cucumber Java: io.cucumber:cucumber-java:7.3.2
Reporting Plugin: me.jvt.cucumber:reporting-plugin:7.3.0


Running Tests
To run the tests, execute the following command in the project root directory:
mvn test

The tests will be executed using the Cucumber JUnit runner (CukesRunner.java).

Reporting
The framework uses the Reporting Plugin (me.jvt.cucumber:reporting-plugin:7.3.0) to generate HTML reports. The reports will be generated in the target/cucumber/cucumber-html-reports directory.

The reports will include information such as:

Overview of features
Overview of scenarios
Overview of steps
Overview of tags
Overview of failures
Detailed reports for each feature, scenario, and step


You can customize the report generation by modifying the plugin configuration in the pom.xml file.
