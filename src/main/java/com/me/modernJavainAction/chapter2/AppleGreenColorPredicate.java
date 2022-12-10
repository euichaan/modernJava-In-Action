package com.me.modernJavainAction.chapter2;

import static com.me.modernJavainAction.chapter2.Color.*;

public class AppleGreenColorPredicate implements ApplePredicate{

  @Override
  public boolean test(Apple apple) {
    return GREEN.equals(apple.getColor());
  }
}
