package com.mynotes.lomboktest.synchronize;

import lombok.Synchronized;

public class SynchronizedExample {

  @Synchronized
  public static void test() {
    System.out.println("test");
  }

}
