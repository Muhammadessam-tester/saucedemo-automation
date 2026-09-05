# SauceDemo UI Automation Testing

A UI automation testing project for the SauceDemo web application using Selenium WebDriver with Java and TestNG.

The project follows the Page Object Model (POM) design pattern to create a clean, maintainable, and reusable automation framework.

The test suite covers login, product inventory, cart, and checkout functionalities.
## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- IntelliJ IDEA
- Page Object Model (POM)
## Project Structure

- `pages/` – Page Objects containing locators and page actions
- `tests/` – Test classes containing test scenarios and assertions
- `BaseTest` – Common WebDriver setup, login, and teardown
- `testng.xml` – Test suite configuration
- `pom.xml` – Maven dependencies and project configuration
## Tested Features

- User login with valid and invalid credentials
- Locked-out user validation
- Login validation for empty fields
- Product inventory item count
- Product sorting by price
- Add product to cart
- Cart item count validation
- Checkout with valid customer information
- Checkout validation for missing required fields
- Complete purchase flow
## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java and Maven are installed.
4. Let Maven download the project dependencies.
5. Run the test suite using `testng.xml`.
## Test Execution

The project contains 13 automated test cases covering Login, Inventory, Cart, and Checkout functionalities.

Latest test execution result:

- Total Tests: 13
- Passed: 13
- Failed: 0
- Skipped: 0
## Automation Project
## Login Feature