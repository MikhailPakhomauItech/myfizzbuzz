package com.demo;

import java.io.PrintStream;

public class FizzBuzzService {
  public void fizzBuzzIt(PrintStream out, int range) {
    if (out == null) {
      throw new IllegalArgumentException("PrintStream should not be a null!");
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= range; i++) {
      sb.append(fizzBuzz(i));
      if (i != range) {
        sb.append(" ");
      }
    }
    out.print(sb);
  }

  String fizzBuzz(int i) {
    if (i % 3 == 0) {
      if (i % 5 == 0) {
        return "FizzBuzz";
      } else {
        return "Fizz";
      }
    } else if (i % 5 == 0) {
      return "Buzz";
    } else {
      return String.valueOf(i);
    }
  }
}
