package chap4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chap4.Dish.menu;

public class Test {
    public static void main(String[] args) {
        Stream<String> stream = menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                }) // Stream<Menu>

                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                }) // Stream<String>
                .limit(3);

    }

    public static void delay() {
        // 流的延迟性质
        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                }) // Stream<Menu>

                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                }) // Stream<String>
                .limit(3) // Stream<String>
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);
    }
}
