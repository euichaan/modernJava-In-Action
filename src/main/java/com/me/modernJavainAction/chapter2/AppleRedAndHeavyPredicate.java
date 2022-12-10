package com.me.modernJavainAction.chapter2;

import static com.me.modernJavainAction.chapter2.Color.*;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
  @Override
  public boolean test(Apple apple) {
    return RED.equals(apple.getColor()) && apple.getWeight() > 150;
  }
}
