package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamPeek {

    public static void main(String[] args) {
        Object[] powers = Stream.iterate(1, p -> p * 2)
                .peek(e -> System.out.println(e))
                .limit(20).toArray();
        System.out.println("----------------------");
        Stream<Double> powers11 = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println(e))
                .limit(20);
        Arrays.stream(powers).forEach(System.out::println);
    }
}
