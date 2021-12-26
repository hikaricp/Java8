package chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

/**
 * 复合Lambda
 */
public class IntegrationLambdas {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, "green"),
                new Apple(80, "areen"),
                new Apple(155, "green"),
                new Apple(120, "red")));

        // 按重量递减排序
        // inventory.sort(comparing(Apple::getWeight)
        //         .reversed());

        // 若有相同重量的苹果按照颜色排序
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println(inventory);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(2);
        System.out.println(result);

        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> g2 = x -> x * 2;
        Function<Integer, Integer> h2 = f1.compose(g2);
        int result1 = h2.apply(1);
        System.out.println(result1);
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
