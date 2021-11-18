package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FizzBuzzServiceTest {

  FizzBuzzService fbs = new FizzBuzzService();


  @Test
  void fizzBuzzIt() {
    fbs.fizzBuzzIt();
  }
}
