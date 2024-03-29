
# Jupiter-toys

## Overview

Jupiter-toys is a Java-based project leveraging Selenium and TestNG to develop automation testing scripts for the Jupiter web application. This project aims to facilitate the testing process by automating interactions with the web application's various pages.

## Project Structure

- **BaseSetup.java**: This file contains the `initialization()` method, which is responsible for initializing page objects and includes functions to navigate between different pages of the application.

- **Pages Directory**: Contains Java classes for each page within the application, facilitating organized and modular testing scripts. The pages included are:
  - `CartPage.java`: Provides functions to validate subtotal, total, prices;
  - `ContactPage.java`: Provide functions to fill items, submit and so on.
  - `HomePage.java`: Provide function to navigate to Shopping Page.
  - `ShopPage.java`: Provide functions to buy items, and get prices.

- **Samples Directory**: Includes basic automation scripts demonstrating how to perform fundamental test steps on the Jupiter web application. These samples serve as a starting point for building more complex tests.

- **Tests Directory**: Houses 3 test cases designed to validate key functionalities of the Jupiter web application. These tests are structured to showcase the application of Selenium and TestNG in automating web testing processes.

  - `TestCase1.java`: 

    1. Go to contact page from the home page 
    2. Click the `Submit`` button
    3. Verify the error messages
    4. Populate mandatory fields
    5. Validate that the errors are gone

  - `TestCase2.java`: 

    1. Go to contact page from the home page
    2. Populate mandatory fields
    3. Click the `Submit`` button
    4. Validate the submission message is successful.

  - `TestCase3.java`:
  
    1. Buy 2 Stuffed Frogs, 5 Fluffy Bunnies, 3 Valentine Bears.
    2. Go to the cart page.
    3. Verify the subtotal for each product is correct.
    4. Verify the price for each product.
    5. Verify that total = sum(sub totals).
