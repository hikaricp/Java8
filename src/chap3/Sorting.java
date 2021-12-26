package chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));

        // inventory.sort(new AppleComparator());

        // inventory.sort(new Comparator<Apple>() {
        //     @Override
        //     public int compare(Apple o1, Apple o2) {
        //         return o1.getWeight().compareTo(o2.getWeight());
        //     }
        // });

        // inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
        // inventory.sort(c);

        inventory.sort(Comparator.comparing(a -> a.getWeight()));
        System.out.println(inventory);
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

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
