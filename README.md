# Overview

#### This repository contains an automated testing project developed using Java and Selenium for an e-commerce web application currently in its pre-production phase. The project was created as part of a QA internship program for the company Quality Island and was collaboratively built by a team of 10 testing interns.

Each team member was responsible for a specific part of the application—typically one major module or a few smaller ones. Within their assigned module(s), testers were tasked with designing and implementing automated regression tests to verify key functionalities. These tests focused on validating the correctness of page titles and URLs, as well as ensuring the visibility and clickability of core UI components.

The goal of the project was to build a reliable suite of automated tests that could help maintain the quality of the application as it moved closer to production.

## Features

* Implementation of the Page Object Model (POM) design pattern to ensure clean, modular, and maintainable code architecture, following industry best practices in QA automation.
* Use of Page Factory to enhance test scalability and optimize execution performance, especially when running a large number of tests frequently.
* Integration with Git version control, enabling smooth, simultaneous collaboration across team members and streamlined code management.
* Application of test annotations to provide concise descriptions for each test method and to define execution priorities where needed.
* Centralization of global configuration data (e.g., base URL, login credentials, browser version) in a dedicated configuration file for easy management and reusability.
* Reduction of code redundancy through a custom TestBase class, which encapsulates shared logic and is extended by lower-level test classes.
* Structured organization of test files within the /pages directory, with subdirectories grouped by specific UI modules of the application for better clarity and modularity.
* Consistent layout within test classes, separating configuration settings, locators, reusable variables, and test operations into well-defined sections.

