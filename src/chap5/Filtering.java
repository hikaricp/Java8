package chap5;

import chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chap4.Dish.menu;

public class Filtering {
    public static void main(String[] args) {
        // 筛选出素食
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // 筛选出数字列表中的偶数，要求是唯一的元素，去重
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 筛选出热量超过300卡路里的前三道菜
        List<Dish> dishesLimit3 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        dishesLimit3.forEach(System.out::println);

        System.out.println("-----");
        // 跳过元素，limit(n)和skip(n)是互补的
        List<Dish> dishesSkip2 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        dishesSkip2.forEach(System.out::println);

        // 测验5.1
        // 筛选前两个荤菜
        menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .forEach(System.out::println);

    }
}
