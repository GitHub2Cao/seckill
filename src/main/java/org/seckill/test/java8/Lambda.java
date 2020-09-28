package org.seckill.test.java8;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
  public static void main(String[] args) {
    // 1 = 1
    // 2 = 2
    // 3 = 2 + 1;
    // 5 = 4 + 1;
    // 10 = 8 + 2;
    // 11 = 8 + 2 + 1;
    // 15 = 8 + 4 + 2 + 1;

    //		System.out.println(Integer.highestOneBit(16));
    //		System.out.println(Integer.highestOneBit(15));
    //		System.out.println(Integer.highestOneBit(8));
    //		System.out.println(Integer.highestOneBit(7));
    //		System.out.println(Integer.highestOneBit(5));
    //		System.out.println(Integer.highestOneBit(3));
    //		System.out.println(Integer.highestOneBit(2));
    //		System.out.println(Integer.highestOneBit(1));

    int sum = 15;
    List<Integer> list = new ArrayList<>();
    int highestOne = Integer.highestOneBit(sum);
    while (highestOne <= sum && sum > 0) {
      list.add(highestOne);
      sum = sum - highestOne;
      highestOne = Integer.highestOneBit(sum);
    }
    System.out.println(list);

    list.stream()
            .forEach(
                    l -> {
                      System.out.println(l);
                    });

    //		A a = new A();
    //		A b = new A();
    //
    //		List<A> list = new ArrayList<>();
    //		list.add(a);
    //		list.add(b);
    //
    //		System.out.println(list.stream().filter(x -> x.getAa() != null && x.getAa().length() !=
    // 0).map(A::getAa).collect(Collectors.toSet()));
    //		System.out.println(list.stream().map(A::getAa).collect(Collectors.toList()));
  }

  static class A {
    private String aa;
    private String bb;

    public String getAa() {
      return aa;
    }

    public void setAa(String aa) {
      this.aa = aa;
    }

    public String getBb() {
      return bb;
    }

    public void setBb(String bb) {
      this.bb = bb;
    }
  }
}
