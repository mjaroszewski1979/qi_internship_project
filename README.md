# Web Application Test Automation – Quality Island Internship

## Overview

#### This repository contains an automated testing project developed using Java and Selenium for an e-commerce web application currently in its pre-production phase. The project was created as part of a QA internship program for the company Quality Island and was collaboratively built by a team of 10 testing interns.

Each team member was responsible for a specific part of the application—typically one major module or a few smaller ones. Within their assigned module(s), testers were tasked with designing and implementing automated regression tests to verify key functionalities. These tests focused on validating the correctness of page titles and URLs, as well as ensuring the visibility and clickability of core UI components.

The goal of the project was to build a reliable suite of automated tests that could help maintain the quality of the application as it moved closer to production.

## Features

* Implementation of the *Page Object Model* (POM) design pattern to ensure clean, modular, and maintainable code architecture, following industry best practices in QA automation.
* Use of *Page Factory* to enhance test scalability and optimize execution performance, especially when running a large number of tests frequently.
* Integration with *Git* version control, enabling smooth, simultaneous collaboration across team members and streamlined code management.
* Application of *test annotations* to provide concise descriptions for each test method and to define execution priorities where needed.
* Centralization of global configuration data (e.g., base URL, login credentials, browser version) in a dedicated *configuration file* for easy management and reusability.
* Reduction of code redundancy through a custom *TestBase class*, which encapsulates shared logic and is extended by lower-level test classes.
* _Structured organization_ of test files within the /pages directory, with subdirectories grouped by specific UI modules of the application for better clarity and modularity.
* _Consistent layout_ within test classes, separating configuration settings, locators, reusable variables, and test operations into well-defined sections.

## My Contribution

#### Took full ownership of the "Settings" module within the e-commerce web application, which allows users to sell courses, digital products, and services. Created automated regression tests to verify:

* Page title correctness
* URL accuracy
* Visibility and clickability of key UI elements
* Relevant test files:
   * [Settings Pages](https://github.com/mjaroszewski1979/qi_internship_project/tree/main/src/test/java/pages/ustawienia)
   * [Settings Tests](https://github.com/mjaroszewski1979/qi_internship_project/tree/main/src/test/java/tests/ustawienia)

#### Developed end-to-end (E2E) automated tests based on client-provided business requirements. Selected examples include:

1. Create a digital product with promotional pricing and validate the checkout link
* Implemented test logic for:
* Creating a digital product priced at 999 PLN
* Setting a promotional price of 499 PLN valid from 12.06.2025 to 24.06.2025
* Assigning a random quantity (1–100)
* Enabling the "Show in catalog" option
* Verifying that the generated purchase link correctly leads to a screen with the "ORDER AND PAY" button
* Relevant test files:
   * [ProduktyCyfroweMJPage.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/pages/produktyCyfrowe/ProduktyCyfroweMJPage.java)
   * [EdycjaProduktyCyfrowePage.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/pages/produktyCyfrowe/EdycjaProduktyCyfrowePage.java)
   * [ProduktyCyfroweMJPageTest.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/tests/produktyCyfroweTests/ProduktyCyfroweMJPageTest.java)

2. Upload and validate a video file in the Media module
* Tested the flow for:
* Navigating to the "Media" > "Video" section
* Uploading a sample video file
* Verifying that the video appears in the video list
* Relevant test files:
   * [DodajWideoPage.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/pages/media/DodajWideoPage.java)
   * [WideoPage.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/pages/media/WideoPage.java)
   * [WideoPageTest.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/tests/mediaTests/WideoPageTest.java)

3. Change a user's password and validate confirmation
* Developed test scenarios for:
* Creating or selecting an existing test user
* Changing the password (minimum 15 characters, including letters and digits)
* Verifying that the strength is marked as "Strong"
* Confirming the update with the appearance of a success message
* Relevant test files:
   * [EdytujUzytkownikaPage.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/pages/uzytkownicy/EdytujUzytkownikaPage.java)
   * [UtworzUzytkownikaPage.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/pages/uzytkownicy/UtworzUzytkownikaPage.java)
   * [EdytujUzytkownikaPageTest.java](https://github.com/mjaroszewski1979/qi_internship_project/blob/main/src/test/java/tests/uzytkownicyTests/EdytujUzytkownikaPageTest.java)

## Technologies Used

* _Java_ – Programming language used to write and structure the automated tests
* _Selenium WebDriver_ – Tool for automating interactions with web browsers
* _Maven_ – Build and dependency management tool for project configuration and library integration
* _TestNG_ – Testing framework for structuring, prioritizing, and managing test execution
* _Allure_ – Tool for generating detailed and visually rich test reports
* _IntelliJ IDEA_ – Integrated Development Environment (IDE) used for writing and debugging code
* _Git / GitHub_ – Version control system for collaborative development and code management

## Important Information

#### The primary purpose of this repository is to showcase my individual contribution to the development of automated tests for a pre-production e-commerce web application, as part of an internship program at Quality Island.

In consideration of the client’s best interests (i.e., the owner of the tested application), all sensitive data has been anonymized. As a result, anyone attempting to run the full test suite may encounter issues due to:
* The absence of a valid application URL
* Replaced or fictitious login credentials
  
Despite these limitations, the code provided retains educational value and offers a clear example of the organizational structure and standards typically adopted in real-world QA automation projects carried out by professional IT/QA teams.

## Contact

For questions or feedback, please contact [mjaroszewski1979.](https://github.com/mjaroszewski1979)

