package chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static chap4.Dish.menu;

/**
 * 归约，将流中的元素反复结合起来
 */
public class Reducing {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product = " + product);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println("max = " + max);

        Optional<Integer> max2 = numbers.stream().reduce(Integer::max);
        max2.ifPresent(System.out::println);

        Optional<Integer> min = numbers.stream().reduce((a, b) -> (a <= b) ? a : b);
        min.ifPresent(System.out::println);

        Optional<Integer> min2 = numbers.stream().reduce(Integer::min);
        min2.ifPresent(System.out::println);

        // 使用map和reduce方法数一数流中有多少个菜呢?
        // 将菜单中每个元素映射为1，然后使用reduce求和
        int countDish = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("countDish = " + countDish);

    }
}
