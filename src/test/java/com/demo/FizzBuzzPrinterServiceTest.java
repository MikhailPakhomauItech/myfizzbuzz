package com.demo;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

class FizzBuzzPrinterServiceTest {

  public static final String DELIMITER = " ";
  private final FizzBuzzPrinterService fbs = new FizzBuzzPrinterService();
  private final Map<Integer, String> divisorToResultStr = new LinkedHashMap<>();

  @BeforeEach
  void setUp() {
    divisorToResultStr.put(3, "Fizz");
    divisorToResultStr.put(5, "Buzz");
    divisorToResultStr.put(15, "Java");
  }

  @Test
  @DisplayName(
      "Should return a string with proper values and without a space at the end of the row")
  void fizzBuzzIt() throws UnsupportedEncodingException {
    final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try (PrintStream ps = new PrintStream(buffer, true, UTF_8.name())) {
      fbs.printFizzBuzz(ps, 20, divisorToResultStr, DELIMITER);
    }
    String result = buffer.toString(UTF_8.name());
    String expected =
        "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzzJava 16 17 Fizz 19 Buzz";
    assertEquals(expected, result);
  }

  @Test
  @DisplayName(
      "Should fail with IllegalArgumentException because got a null instead of a buffer as argument")
  void fizzBuzzItGetNullInsteadOfBuffer() {
    assertThrows(
        IllegalArgumentException.class,
        () -> fbs.printFizzBuzz(null, 20, divisorToResultStr, DELIMITER));
  }

  @Test
  @DisplayName(
      "Should fail with IllegalArgumentException because got a null instead of a divisorToResultStr map")
  void fizzBuzzItGetNullInsteadOfDivisorToResultStrMap() throws UnsupportedEncodingException {
    try (PrintStream ps = new PrintStream(new ByteArrayOutputStream(), true, UTF_8.name())) {
      assertThrows(
          IllegalArgumentException.class, () -> fbs.printFizzBuzz(ps, 20, null, DELIMITER));
    }
  }

  @Test
  @DisplayName("Should not fail with negative range and just return an empty row")
  void fizzBuzzItGetNegativeRange() throws UnsupportedEncodingException {
    final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try (PrintStream ps = new PrintStream(buffer, true, UTF_8.name())) {
      fbs.printFizzBuzz(ps, -1, divisorToResultStr, DELIMITER);
    }
    String result = buffer.toString(UTF_8.name());
    assertEquals("", result);
  }

  @ParameterizedTest
  @ValueSource(ints = {3, 6})
  void fizzBuzzTestIsFizz(int i) {
    Assertions.assertEquals("Fizz", fbs.fizzBuzz(i, divisorToResultStr));
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 10})
  void fizzBuzzTestIsBuzz(int i) {
    Assertions.assertEquals("Buzz", fbs.fizzBuzz(i, divisorToResultStr));
  }

  @ParameterizedTest
  @ValueSource(ints = {15, 30})
  void fizzBuzzTestIsFizzBuzz(int i) {
    Assertions.assertEquals("FizzBuzzJava", fbs.fizzBuzz(i, divisorToResultStr));
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 7, 8, 11, 13, 14})
  void fizzBuzzTestIsNumber(int i) {
    String result = fbs.fizzBuzz(i, divisorToResultStr);
    Assertions.assertNotEquals("Fizz", result);
    Assertions.assertNotEquals("Buzz", result);
    Assertions.assertNotEquals("FizzBuzzJava", result);
    Assertions.assertNotEquals("Java", result);
  }
}
