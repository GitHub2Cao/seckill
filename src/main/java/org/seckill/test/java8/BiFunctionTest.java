package org.seckill.test.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionTest {
  public static void main(String[] args) {
    BiFunctionTest test = new BiFunctionTest();
    //        求两个数之和
    System.out.println(test.compute1(4, num -> num * num));

    System.out.println(test.compute2(3, 4, Integer::sum));

    System.out.println(test.compute3(3, 4, Integer::sum, item -> item * item));
    //        等价于
    System.out.println(test.compute3(3, 4, (num1, num2) -> num1 * num2, value -> value * value));

  }

  public int compute1(int a, Function<Integer, Integer> function) {
    return function.apply(a);
  }

  public int compute2(int num1, int num2, BiFunction<Integer, Integer, Integer> function) {
    return function.apply(num1, num2);
  }

  public int compute3(
      int num1,
      int num2,
      BiFunction<Integer, Integer, Integer> function,
      Function<Integer, Integer> function2) {
    return function.andThen(function2).apply(num1, num2);
  }
}
