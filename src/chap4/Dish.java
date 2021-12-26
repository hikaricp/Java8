package chap4;

import java.util.Arrays;
import java.util.List;

/**
 * 菜肴
 */
public class Dish {
    // 菜肴名称
    private final String name;
    // 素食
    private final boolean vegetarian;
    // 卡路里
    private final int calories;
    // 菜肴类型
    private final Type type;

    public Dish(String name, boolean vegetarian, int colories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = colories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    // 菜肴类型
    public enum Type {
        // 肉、鱼肉、其他
        MEAT, FISH, OTHER
    }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList(
                    // 猪肉
                    new Dish("pork", false, 800, Type.MEAT),
                    // 牛肉
                    new Dish("beef", false, 700, Type.MEAT),
                    // 鸡肉
                    new Dish("chicken", false, 400, Type.MEAT),
                    // 炸薯条
                    new Dish("french fries", false, 530, Type.OTHER),
                    // 大米
                    new Dish("rice", true, 350, Type.OTHER),
                    // 水果
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    // 披萨
                    new Dish("pizza", false, 550, Type.OTHER),
                    // 对虾
                    new Dish("prawns", true, 400, Type.FISH),
                    // 鲑鱼
                    new Dish("salmon", false, 450, Type.FISH)
            );

}
