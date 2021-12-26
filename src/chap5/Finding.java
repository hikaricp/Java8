package chap5;

import chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static chap4.Dish.menu;

public class Finding {

    public static void main(String[] args) {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));

        // 给定一个数字列表，找出第一个平方 能被3整除的数
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(x -> x * x)
                .filter(n -> n % 3 == 0)
                .findFirst();
        firstSquareDivisibleByThree.ifPresent(System.out::println);
    }

    // 匹配其中一个
    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    // 匹配全部
    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    // 全部不匹配
    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    // 查找第一个素食元素
    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }

}
