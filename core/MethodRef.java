import java.util.Arrays;
import java.util.List;

public class MethodRef {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Hitesh", "Niraj", "Kapil");

        List<String> uNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        uNames.forEach(System.out::println);
    }
}
