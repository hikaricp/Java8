package chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static chap4.Dish.menu;

public class StreamBasic {
    public static void main(String[] args) {
        // Java7
        getLowCaloricDishesNamesInJava7(menu).forEach(System.out::println);

        System.out.println("--------");

        // Java8
        getLowCaloricDishesNamesInJava8(menu).forEach(System.out::println);
    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        // 用于存放低热量的菜肴
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesNames = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesNames.add(d.getName());
        }
        return lowCaloricDishesNames;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        List<String> lowCaloricDishesNames = dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        return lowCaloricDishesNames;
    }
}


