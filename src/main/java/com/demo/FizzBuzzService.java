package com.demo;

import java.io.PrintStream;

public class FizzBuzzService {
  public void fizzBuzzIt(PrintStream out, int rate) {
    if (out == null) {
      throw new IllegalArgumentException("PrintStream should be not a null!");
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= rate; i++) {
      sb.append(fizzBuzz(i));
      if (i != rate) {
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
