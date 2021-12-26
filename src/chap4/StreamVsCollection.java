package chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流只能使用一次
 */
public class StreamVsCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);

        // 流被使用后，就被消费完了，会报异常 IllegalStateException
        // s.forEach(System.out::println);
    }
}
