package chap5;

import chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chap4.Dish.menu;

public class Mapping {
    public static void main(String[] args) {
        // 映射
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        // 返回一个字母个数的新列表
        List<String> words1 = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words1.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        // 获取每道菜名字的长度
        List<Integer> dishNameLengths = menu.stream()
                .map(d -> d.getName())
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLengths);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> collect = words.stream()
                .map(w -> w.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect.toString());

        // map and Arrays.stream()
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWord = Arrays.stream(arrayOfWords);
        // 仍然不能解决问题，得到的是Stream<String>列表，这不是我们想要的
        List<Stream<String>> collect1 = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        // flatMap
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);

        // 测验5.2. 给定一个数字列表，返回由每个数的平方构成的列表
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbersTo2 = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(numbersTo2);

        // 给定两个数字列表，返回所有的对数
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()    // Stream<Integer>
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        print(pairs);

        // 扩展前例子，只返回总和能被3整除的数
        List<int[]> pairs2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        print(pairs2);
    }

    public static void print(List<int[]> pairs) {
        StringBuilder res = new StringBuilder("[");
        for (int[] pair : pairs) {
            for (int i = 0; i < pair.length; i += 2) {
                res.append("(" + pair[i] + "," + pair[i + 1] + ")");
            }
        }
        res.append("]");
        System.out.println(res.toString());
    }
}
