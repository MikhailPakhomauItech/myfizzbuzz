package com.demo;

import java.io.PrintStream;
import java.util.Map;

public class FizzBuzzPrinterService {
  /**
   * Checks all number since 1 to `range` and replaces values for a value from divisorToResultStr if a
   * number can be divided by the divisor without the remainder. Prints result to `out` using delimiter
   * from parameters
   *
   * @param out outputStream which will have result of the function call
   * @param range
   * @param divisorToResultStr map with a divisor key and replacement string in value
   * @param delimiter
   * @throws IllegalArgumentException if `out` or `divisorToResultStr` are null
   */
  public void printFizzBuzz(
      PrintStream out, int range, Map<Integer, String> divisorToResultStr, String delimiter) {
    validate(out, divisorToResultStr);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= range; i++) {
      sb.append(fizzBuzz(i, divisorToResultStr));
      if (i != range) {
        sb.append(delimiter);
      }
    }
    out.print(sb);
  }

  String fizzBuzz(int i, Map<Integer, String> divisorToResultStr) {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, String> es : divisorToResultStr.entrySet()) {
      if (i % es.getKey() == 0) {
        sb.append(es.getValue());
      }
    }
    if (sb.length() != 0) {
      return sb.toString();
    }
    return String.valueOf(i);
  }

  private void validate(PrintStream out, Map<Integer, String> divisorToResultStr) {
    if (out == null) {
      throw new IllegalArgumentException("PrintStream should not be a null!");
    }

    if (divisorToResultStr == null) {
      throw new IllegalArgumentException("divisorToResultStr map should not be a null!");
    }
  }
}
