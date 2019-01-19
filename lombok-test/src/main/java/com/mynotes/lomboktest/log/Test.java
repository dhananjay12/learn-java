package com.mynotes.lomboktest.log;

import lombok.extern.java.Log;

@Log
public class Test {

  public static void main(String[] args) {
    log.severe("Log message");
  }

}
