# Performance Testing for https://automationintesting.online/

## Introduction
Below I have outlined the approach for conducting performance testing on the 'https://automationintesting.online/' website. The objective is to evaluate the performance and scalability of the website under different load conditions.

## Performance Testing Types
Below I have created three performance testing scripts, each representing a different type of performance testing. The chosen tools for scripting and execution are:

1. Load Testing:
   - Tool: Apache JMeter
   - Script: load_test_1
   - Objective: Measure the website's performance under expected load conditions.

2. Stress Testing:
   - Tool: Gatling
   - Script: stress_test_1
   - Objective: Evaluate the website's behavior and performance under high load conditions.

3. Endurance Testing:
   - Tool: Locust
   - Script: endurance_test_1
   - Objective: Assess the website's performance and stability over an extended period of time.

## Test Scenarios
For each performance testing type, I defined specific test scenarios to cover different aspects of the website's performance. These scenarios may include:

1. Load Testing Scenarios:
   - Simulate concurrent user sessions accessing different pages of the website.
   - Measure response times, throughput, and resource utilization.

To write a performance test script for the given scenarios using JMeter, I set up a test plan in JMeter as below:

- Define the number of users (threads) that will simulate concurrent sessions. For e.g, the test plan script `load_test_1.xml` simulates 10 users accessing the website.
- Define the pages of the website that will be accessed, and add additional HTTPSamplerProxy elements for each page to be tested.
- To measure response times, throughput, and resource utilization, I would add listeners to the test plan. For example, add a SummaryReport and a ViewResultsTree to view detailed results of the test.

2. Stress Testing Scenarios:
   - Generate a high number of concurrent requests to stress the website's resources.
   - Monitor system metrics and identify performance bottlenecks.

   The example script `stress_test_1.scala` will generate 1000 users at once, each making 1000 GET requests to the homepage of `https://automationintesting.online/` with a 1-second pause between each request.

3. Endurance Testing Scenarios:
   - Run a continuous load on the website for an extended duration.
   - Monitor memory usage, CPU utilization, and database performance.

   The script `endurance_test_1.py` will generate users that wait between 1 and 5 seconds (this simulates real-world users who don't hammer the server non-stop) and then make a GET request to the homepage of https://automationintesting.online/.

   To run the script, run locust -f endurance_test_1.py from the command line. Then open a web browser to http://localhost:8089 to start the test and set the number of users and spawn rate.

## Test Execution
The performance testing scripts will be executed in a controlled test environment that closely resembles the production environment. The execution process will involve:

1. Test Environment Setup:
   - Provision a dedicated test environment with similar hardware and software configurations as the production environment.
   - Install and configure the necessary tools for performance testing.

2. Test Data Preparation:
   - Identify and generate realistic test data to be used during the performance tests.

3. Test Execution:
   - Execute the performance testing scripts for each type of performance testing.
   - Monitor and collect performance metrics during the test execution.

4. Results Analysis:
   - Analyze the collected performance metrics to identify any performance issues or bottlenecks.
   - Generate performance reports with detailed findings and recommendations.


