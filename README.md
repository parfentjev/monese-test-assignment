# Monese test automation assignment

This repository contains a test automation project created for Monese.

The project has the following requirements:

* Implement API tests with REST Assured.
* Implement UI tests for Android with Appium.
* Implement 2-3 tests.
* Ensure one test intentionally fails.
* Write code that is easy to maintain and extend.
* Generate a test report after execution.
* Provide human-readable descriptions for automated tests.

# Build

This project combines API and UI tests. In a real-life scenario, these tests might be stored in separate repositories
due to their differences. However, for this test assignment, a multi-module architecture has been chosen.

Build the project before running tests:

`mvn clean install -DskipTests`

# API tests module

## Run

API tests interact with [Go REST](https://gorest.co.in/), a service designed for testing. To make requests, you need to
register on the website and obtain an API token. After obtaining the token, update the token value in
`api-test/src/main/resources/api-test.properties`.

To run API tests, execute:

```shell
cd api-test
mvn test
```

## Test cases

The API test suite includes three test cases.

`org.monese.apitest.UsersApiTest.createUser`

A positive test case to create a user.

1. Make a POST request to create a new user, all fields should have valid values.
2. Verify that the status code is 201.
3. Verify that the response: id should be greater than 0, other fields are equal to values in the POST request.
4. Get the user by id.
5. Verify that the status code is 200.
6. Verify that the response: id should be equal to the known id from the step #2, other fields are equal to values in
   the
   POST request.

`org.monese.apitest.UsersApiTest.createUserWithoutEmail`

A negative test case to create a user without a mandatory field (email).

1. Make a POST request to create a new user, all fields should have valid values, but email - don't send it.
2. Verify that the status code is 422.
3. Verify that the response says that the email field can't be blank.

`org.monese.apitest.UsersApiTest.createUserAndVerifyIdIsNull`

The test assignment requires that one test case should fail. Here we successfully create a user and expect the id to
be null. Since the id is never null, the test always fails.

1. Make a POST request to create a new user, all fields should have valid values, but name - don't send it.
2. Verify that the status code is 201.
3. Verify that the response: id should be null, other fields are equal to values in the POST request.

The test should fail at the step #3.

# UI test module

## Run

The UI tests connect to a local Appium service by default (127.0.0.1:4723). Modify properties in
`./ui-test/src/main/resources/ui-test.properties` to change this configuration. An Android virtual device must be
running. This code was tested against Android API 34.

The tests use the open-source Android app [TranslateYou](https://github.com/you-apps/TranslateYou/) for translation. The
APK file is provided with this assignment and can be found at `./ui-test/src/main/resources/translate-you.apk`.

To run the UI tests, execute:

```shell
cd ui-test
mvn test
```

## Test cases

The UI test suite includes three test cases.

`org.monese.uitest.TranslateYouUiTest.translateFromEnglishToGerman`

A positive test case to translate a string from English to German.

1. Launch the app.
2. Select the English language to translate from.
3. Select the German language to translate to.
4. Verify that after selecting, both language names are actually displayed on the respective buttons.
5. In the input field, enter: "Hello! Good morning."
6. In the output field, verify: "Hallo! Guten Morgen."

`org.monese.uitest.TranslateYouUiTest.translateFromEnglishToGerman`

A negative test case to translate a string from English to German.

1. Launch the app.
2. Click on the three dots to expand the menu.
3. Click on the Settings item.
4. Select DeepL as the service provider.
5. Click on the back button.
6. Verify that the error message appears: "Error in communicating with the server."

`org.monese.uitest.TranslateYouUiTest.translateFromEnglishToGerman`

A failing test case to translate a string from English to Estonian.

1. Launch the app.
2. Select the English language to translate from.
3. Select the Estonian language to translate to.

The test should fail at step #3, as the Estonian language is not available for selection in the default translation
service.

# Reporting

HTML reports are automatically generated and can be found at:

```
./{projectDir}/target/surefire-reports/index.html
```

A cleaner and more navigable "emailable" version of the report can be accessed at:

```
./{projectDir}/target/surefire-reports/emailable-report.html
```

In a real-life project, the Allure Framework could be used for informative and visually appealing reports. Jenkins'
plugins are often used for report generation and distribution.
