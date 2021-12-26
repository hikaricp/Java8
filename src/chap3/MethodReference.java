package chap3;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple("red", 150),
                new Apple("green", 80),
                new Apple("blue", 150),
                new Apple("yellow", 60)
        );
        // inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);

        List<String> str = Arrays.asList("a", "b", "A", "B");
        // str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);

        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c2.get();

        Function<Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(180);
        System.out.println(a3.getWeight());

        Function<Integer, Apple> c4 = weight -> new Apple(weight);
        Apple a4 = c4.apply(80);
        System.out.println(a4.getWeight());

        List<Integer> weights = Arrays.asList(7, 3, 4, 90);
        List<Apple> apples = map(weights, Apple::new);
        for (Apple apple : apples) {
            System.out.println("weight -> " + apple.getWeight());
        }

        BiFunction<String, Integer, Apple> c5 = Apple::new;
        Apple a5 = c5.apply("red", 180);
        System.out.println(a5);

        BiFunction<String, Integer, Apple> c6 = (color, weight) -> new Apple(color, weight);
        Apple a6 = c6.apply("green", 180);
        System.out.println(a6);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    static class Apple {
        private String color;
        private Integer weight;

        public Apple() {
            System.out.println("Apple::new");
        }

        public Apple(Integer weight) {
            this.weight = weight;
        }

        public Apple(String color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

}


