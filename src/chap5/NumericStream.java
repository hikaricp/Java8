package chap5;

import chap4.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static chap4.Dish.menu;

/**
 * 数值流
 * 解决装箱带来的复杂性
 */
public class NumericStream {
    public static void main(String[] args) {
        // 对menu中的卡路里求和
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("calories = " + calories);

        // 将数值流转换为Stream
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        // 默认值OptionalInt，计算最大元素
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        // 如果没有最大值，显式的提供一个默认值
        int max = maxCalories.orElse(1);
        System.out.println("max = " + max);

        // 数值范围
        // rangeClosed()包含两端
        IntStream eventNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(eventNumbers.count());

        // range()不包含尾部
        long count = IntStream.range(1, 100).count();
        System.out.println("count = " + count);

        // 勾股数
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        System.out.println("==============================");
        // 更优的做法
        Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(
                                b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples2
                .limit(5).
                forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }
}
