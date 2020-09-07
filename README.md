<h2>Test Automation project of Demokauppa </h2>

Tech used in it:

Cucumber for Java as a BDD framework;<br> 
JUnit 5 as a test framework;<br>
Allure integrated with Cucumber as a reporting solution;<br>
Log4j as a logger;<br>
Maven as a build tool.

To run tests, please run the following command:

<code> mvn -Dbrowser=<b><i>BROWSER_NAME</i></b> clean test </code>

Supported browsers: Firefox, Chrome.

To generate allure report, run this command after the tests:

<code> mvn allure:serve </code>

Currently available test tags:

<code> @Smoke </code>

<b>Use example:</b>

Let's say you want to run a smoke test suite on Firefox, here is how to do that:

<code> mvn -Dbrowser=firefox -Dcucumber.options="--tags @Smoke" clean test </code>
