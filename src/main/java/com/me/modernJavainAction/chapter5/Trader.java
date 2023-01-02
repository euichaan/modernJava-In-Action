package com.me.modernJavainAction.chapter5;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Trader {
  private final String name;
  private final String city;

  @Override
  public int hashCode() {
    int hash = 17;
    hash = hash * 31 + (name == null ? 0 : name.hashCode());
    hash = hash * 31 + (city == null ? 0 : city.hashCode());
    return hash;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (!(other instanceof Trader)) {
      return false;
    }
    Trader o = (Trader) other;
    boolean eq = Objects.equals(name,  o.getName());
    eq = eq && Objects.equals(city, o.getCity());
    return eq;
  }

  @Override
  public String toString() {
    return "Trader:" + this.name + " in " + this.city;
  }
}
