package chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 将List类型抽象化，使用泛型
 */
public class FilteringEverything {
    public static void main(String[] args) {
        List<FilteringApples.Apple> inventory = Arrays.asList(
                new FilteringApples.Apple(80, "red"),
                new FilteringApples.Apple(70, "green"),
                new FilteringApples.Apple(150, "red")
        );

        List<Integer> numbers = Arrays.asList(1, 2, 60, 90, 300, 45);

        List<FilteringApples.Apple> redApples = filter(inventory, (FilteringApples.Apple a) -> "red".equals(a.getColor()));

        List<Integer> evenNumbers = filter(numbers, num -> num % 2 == 0);

        System.out.println(redApples);
        System.out.println(evenNumbers);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
