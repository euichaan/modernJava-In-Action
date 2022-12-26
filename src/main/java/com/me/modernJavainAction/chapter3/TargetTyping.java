package com.me.modernJavainAction.chapter3;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class TargetTyping {

  public static void main(String[] args) {
    Callable<Integer> c = () -> 42;
    PrivilegedAction<Integer> p = () -> 42;

    List<String> list = new ArrayList<>();
    list.add("hello");

    Predicate<String> ps = s -> list.add(s);
    int portNumber = 1337;
    Runnable r = () -> System.out.println(portNumber); // Error 
    portNumber = 31337;
  }

}
