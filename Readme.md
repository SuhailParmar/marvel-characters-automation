# Characters API Automation

Acceptance level tests for the Characters API. We expect the server to be run on localhost, with http on port
8080.

## IntelliJ plugins required
- Cucumber for Java
- Gherkin
- Lombok

## How to run

### Through Maven - to build the reports.
```mvn clean verify```

The report looks as followws in the logs:
```
[INFO] -----------------------------------------
[INFO]  SERENITY TESTS : SUCCESS
[INFO] -----------------------------------------
[INFO] | Tests executed         | 5
[INFO] | Tests passed           | 5
[INFO] | Tests failed           | 0
[INFO] | Tests with errors      | 0
[INFO] | Tests compromised      | 0
[INFO] | Tests pending          | 0
[INFO] | Tests ignored/skipped  | 0
[INFO] ------------------------ | --------------
[INFO] | Total Duration         | 3s 766ms
[INFO] | Fastest test took      | 029ms
[INFO] | Slowest test took      | 2s 952ms
[INFO] -----------------------------------------
[INFO]
[INFO] SERENITY REPORTS
[INFO]   - Full Report: file:///C:/Projects/MarvelApiAutomation/target/site/serenity/index.html
```

### Through IntelliJ - to debug 
1. Append the debug runner annotation '@debug` above the scenario you want to test.
2. Add your breakpoints
3. Debug the debug runner

### Through IntelliJ - to run the whole suite
1. Add your breakpoints
2. Run the test suite runner

## Technologies Used
- Java11
- SerenityBDD 
- Gherkin
- Cucumber  
- Maven