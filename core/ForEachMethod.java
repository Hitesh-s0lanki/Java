import java.util.Arrays;
import java.util.List;
// import java.util.stream.Stream;

public class ForEachMethod {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4, 5, 6, 7, 7);

        // Stream<Integer> s1 = nums.stream();
        // Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);

        // int result = s2.reduce(0, (c, e) -> c + e);

        int result = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (a, b) -> a + b);

        System.out.println(result);

        // s1.forEach(n -> System.out.print(n + " "));
        // s2.forEach(n -> System.out.print(n + " "));

        // System.out.println();

        // nums.forEach(n -> System.out.print(n + " "));
    }
}
