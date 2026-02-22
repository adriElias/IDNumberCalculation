# Parameterized Tests with JUnit 5

Educational Java project to learn **parameterized tests** in JUnit 5 using a simple, real-world example: calculating the control letter of a Spanish DNI (ID number).

## Objective

- Implement a clean, testable method to calculate the DNI control letter from a number
- Write parameterized tests with `@ParameterizedTest` to validate multiple cases elegantly
- Cover both valid and invalid inputs (edge cases, exceptions)
- Understand how parameterized tests reduce code duplication and improve readability

## Statement Summary

1. Create a `DniCalculator` class with a method `char calculateLetter(long dniNumber)`
2. The method must compute the correct control letter using the standard Spanish DNI formula
3. Write JUnit 5 parameterized tests covering at least:
    - 10 valid DNI numbers → check correct letter
    - Invalid inputs (negative numbers, too large, etc.) → expect exception
4. Use `@ParameterizedTest`, `@ValueSource`, `@CsvSource` or `@MethodSource`

## Project Structure (Maven example)
```text
dni-letter-tests/
├── pom.xml
└── src/
├── main/java/
│   └── DniCalculator.java
└── test/java/
└── DniCalculatorTest.java
```
## How to Run Tests

```bash
# Maven
mvn test
```
## Or run directly in your IDE
### Example Test Snippet
```Java
@ParameterizedTest
@CsvSource({
    "12345678, Z",
    "87654321, X",
    "00000000, T",
    "99999999, Z"
})
void shouldCalculateCorrectLetter(long number, char expectedLetter) {
    assertEquals(expectedLetter, calculator.calculateLetter(number));
}
```