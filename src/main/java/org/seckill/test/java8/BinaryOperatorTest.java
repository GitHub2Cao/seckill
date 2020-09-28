package org.seckill.test.java8;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiFunction;

public class BinaryOperatorTest {
  public static void main(String[] args) {
    BinaryOperatorTest test = new BinaryOperatorTest();
    System.out.println(test.compute(3, 4, Integer::sum));
    System.out.println(test.minByComparator(5, 6, Comparator.comparingInt(num -> num)));
  }

  public interface BinaryOperator<T> extends BiFunction<T, T, T> {
     static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) {
      Objects.requireNonNull(comparator);
      return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
    }
  }

  public int compute(int num1, int num2, BinaryOperator<Integer> function) {
    return function.apply(num1, num2);
  }

  public int minByComparator(int num1, int num2, Comparator<Integer> comparator) {
    return BinaryOperator.minBy(comparator).apply(num1, num2);
  }
}
