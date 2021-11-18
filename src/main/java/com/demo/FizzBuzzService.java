package com.demo;

import java.io.PrintStream;
import java.util.Map;
import java.util.stream.Collectors;

public class FizzBuzzService {
  public void fizzBuzzIt(PrintStream out, int range, Map<Integer, String> delimiterToResultStr) {
    validate(out, delimiterToResultStr);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= range; i++) {
      sb.append(fizzBuzz(i, delimiterToResultStr));
      if (i != range) {
        sb.append(" ");
      }
    }
    out.print(sb);
  }


  String fizzBuzz(int i, Map<Integer, String> divisorToResultStr) {
    String fbz = divisorToResultStr.entrySet().stream()
        .filter(es -> i % es.getKey() == 0)
        .map(Map.Entry::getValue)
        .collect(Collectors.joining());
    if (!fbz.isEmpty()) {
      return fbz;
    }
    return String.valueOf(i);
  }

  private void validate(PrintStream out, Map<Integer, String> delimiterToResultStr) {
    if (out == null) {
      throw new IllegalArgumentException("PrintStream should not be a null!");
    }

    if (delimiterToResultStr == null) {
      throw new IllegalArgumentException("delimiterToResultStr map should not be a null!");
    }
  }
}
