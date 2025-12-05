# Selenium TestNG Login Automation

A demo project to automate login testing on a demo website using **Selenium WebDriver** and **TestNG**.  
This project includes multiple test cases, retry logic, listeners, and screenshot capture for failed tests.

---

## Features

- Data-driven login tests using TestNG `DataProvider`
- Retry failed tests automatically
- Capture screenshots for failed login attempts
- Print post-login UI information to console
- BaseTest setup with reusable WebDriver
- Page Object Model (POM) for Login and Success pages

---

## Tech Stack

- Java 17  
- Selenium WebDriver  
- TestNG  
- WebDriverManager  
- Maven  

---

## Project Structure

selenium-demo-project
├── pom.xml
└── src
├── main
│ └── java
└── test
├── java
│ ├── base
│ │ └── BaseTest.java
│ ├── pages
│ │ ├── LoginPage.java
│ │ └── SuccessPage.java
│ ├── utils
│ │ ├── RetryAnalyzer.java
│ │ └── TestListener.java
│ └── tests
│ └── LoginTest.java
└── resources
└── testng.xml
