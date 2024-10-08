--FindFakeBar--
This is a test automation framework using Java, Selenium, and Cucumber for BDD (Behavior-Driven Development).
The framework is designed to use the scale tool provided and isolate the "fake gold bar" that weighs less than its "real" counterparts.

Project Structure
FindFakeBar/
├── src/
│    │ 
│    └── test/
│       ├── java/
│       │   └── com/brian/
│       │            |    
|       |            ├── pages/
|       |            |     └── BalanceScalePage.java
|       |            |
|       |            ├── runners/
|       |            |     ├── CukesRunner.java
|       |            |     └── FailedTestRunner .java
|       |            | 
|       |            ├── step_defs/
|       |            |     └──Scale_StepDefinitions.java
|       |            | 
|       |            └── utilities/
|       |                  ├── Driver.java
|       |                  └── ConfigurationReader.java
│       └── resources/
│             └── features/
│                 └── FakeFinder.feature
│ 
├── configuration.properties
├── pom.xml
└── target/

--Installation--
To set up the project locally:

1. **Clone the repository**:
   Execute the following command in the terminal to clone the repository:
   git clone https://github.com/bjmorton/FindTheFakeBars.git

2. **Navigate to the project directory**:
   Execute the following command in the terminal to navigate to the project directory:
   cd FindFakeBars

4. **Install the dependencies**:
   Maven will automatically download the required dependencies when you run the tests or build the project.

--Dependencies--
The project uses the following dependencies:

Selenium Java: org.seleniumhq.selenium:selenium-java:4.18.1
Cucumber JUnit: io.cucumber:cucumber-junit:7.3.2
Cucumber Java: io.cucumber:cucumber-java:7.3.2
Reporting Plugin: me.jvt.cucumber:reporting-plugin:7.3.0


--Running Tests--
Please note: The default browser for this test is Chrome. Ensure you have Google Chrome OR firefox installed in order to run this test.
If you wish to change the browser type for this test, simply navigate to the configuration.properties file and replace 'chrome' with 'firefox'.

To run the tests, execute the following command in the project root directory (terminal):
mvn test

The tests will be executed using the Cucumber JUnit runner (CukesRunner.java).

Upon test excecution a chrome browser will open and maximize. The program will execute the test, then close the chrome browser after the test has succeeded.


--Reporting--
After the test has successfully been completed, you can click the auto-generated public report link in the console to view a report of the test execution in your browser.

Additionally, the framework uses the Reporting Plugin (me.jvt.cucumber:reporting-plugin:7.3.0) to generate HTML reports. These reports will be generated in the target/cucumber/cucumber-html-reports directory.

The HTML reports will include information such as:

Overview of features
Overview of scenarios
Overview of steps
Overview of tags
Overview of failures
Detailed reports for each feature, scenario, and step

You can customize the report generation by modifying the plugin configuration in the pom.xml file.


--Contact Information--
Please reach out if you have any questions or comments.

name:  Brian Morton
email: mortontech@yahoo.com
phone: 323-945-9585

