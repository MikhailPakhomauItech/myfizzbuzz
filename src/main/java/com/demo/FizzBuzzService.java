package com.demo;

public class FizzBuzzService {
  public void fizzBuzzIt() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 100; i++) {
      if (0 == i % 3) {
        if (0 == i % 5) {
          sb.append("FizzBuzz");
        } else {
          sb.append("Fizz");
        }
      } else if (0 == i % 5) {
        sb.append("Buzz");
      } else {
        sb.append(i);
      }
      if (i != 100) {
        sb.append(" ");
      }
    }
    System.out.println(sb);
  }
}
