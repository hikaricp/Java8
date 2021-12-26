package chap5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 构建流
 */
public class BuildingStream {
    public static void main(String[] args) {
        // 由值直接创建流
        Stream<String> stream = Stream.of("Java 8", "Lambda", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // 由数组创建流
        int[] numbers = {1, 3, 5, 7, 9};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

        // 由文件生成流
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("uniqueWords = " + uniqueWords);


        // 创建无限流
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 斐波那契元祖序列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        // 通过map提取斐波那锲元祖序列中的斐波那锲数列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
    }
}
