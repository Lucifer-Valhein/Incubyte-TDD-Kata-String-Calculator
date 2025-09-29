# Incubyte TDD Kata – String Calculator

## 📖 Overview
This project is an implementation of the **String Calculator Kata** as part of the **Incubyte TDD assessment**.  
The goal is to showcase the ability to build well-tested, clean, and maintainable code using **Test-Driven Development (TDD)** principles.

The `StringCalculator` class implements a calculator that parses a string of numbers separated by various delimiters and returns their sum.  
All functionality is developed **incrementally through automated tests**, following the Red → Green → Refactor cycle.

---

## ✨ Features Implemented
1. Returns **0 for empty input**.  
2. Handles a **single number** input and returns it.  
3. Computes the **sum of two or more numbers** separated by commas.  
4. Supports **newline (`\n`) as a valid delimiter** along with commas.  
5. Supports **custom delimiters** in the form:
   - `//;\n1;2` → delimiter `;`
   - `//[***]\n1***2***3` → multi-character delimiter
   - `//[*][%]\n1*2%3` → multiple delimiters
6. **Ignores numbers greater than 1000**.  
7. Throws an **exception for negative numbers**, listing **all negatives** in the message:  
   > `negative numbers not allowed -2,-5`
8. Fully tested with **JUnit 5** and **Maven** build support.

---

## 🛠️ Tech Stack
- Java 17
- Maven
- JUnit 5
- Regex for parsing custom delimiters

---

## 📂 Project Structure
incubyte-string-calculator-tdd/
├── pom.xml
├── README.md
└── src
├── main
│ └── java
│ └── com/incubyte/
│ └── StringCalculator.java
└── test
└── java
└── com/incubyte/
└── StringCalculatorTest.java


---

## ▶️ How to Run Tests
```bash
# Clone repository
git clone <your-repo-url>
cd incubyte-string-calculator-tdd

# Ensure Java 17+ and Maven 3.8+ are installed
java -version
mvn -v

# Run all tests
mvn clean test

