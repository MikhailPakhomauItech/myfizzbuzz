package com.demo;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

class FizzBuzzServiceTest {

  FizzBuzzService fbs = new FizzBuzzService();

  @Test
  @DisplayName("Should return a string with proper values and without a space at the end of the row")
  void fizzBuzzIt() throws UnsupportedEncodingException {
    final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try (PrintStream ps = new PrintStream(buffer, true, UTF_8.name())) {
      fbs.fizzBuzzIt(ps, 20);
    }
    String result = buffer.toString(UTF_8.name());
    String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz";
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("Should fail with IllegalArgumentException because got a null instead of a buffer as argument")
  void fizzBuzzItGetNullInsteadOfBuffer() {
    assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzzIt(null, 20));
  }

  @Test
  @DisplayName("Should not fail with negative range and just return an empty row")
  void fizzBuzzItGetNegativeRange() throws UnsupportedEncodingException {
    final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try (PrintStream ps = new PrintStream(buffer, true, UTF_8.name())) {
      fbs.fizzBuzzIt(ps, -1);
    }
    String result = buffer.toString(UTF_8.name());
    assertEquals("", result);
  }

  @ParameterizedTest
  @ValueSource(ints = {3, 6})
  void fizzBuzzTestIsFizz(int i) {
    Assertions.assertEquals("Fizz", fbs.fizzBuzz(i));
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 10})
  void fizzBuzzTestIsBuzz(int i) {
    Assertions.assertEquals("Buzz", fbs.fizzBuzz(i));
  }

  @ParameterizedTest
  @ValueSource(ints = {15, 30})
  void fizzBuzzTestIsFizzBuzz(int i) {
    Assertions.assertEquals("FizzBuzz", fbs.fizzBuzz(i));
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 7, 8, 11, 13, 14})
  void fizzBuzzTestIsNumber(int i) {
    String result = fbs.fizzBuzz(i);
    Assertions.assertNotEquals("Fizz", result);
    Assertions.assertNotEquals("Buzz", result);
    Assertions.assertNotEquals("FizzBuzz", result);
  }
}
