import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {

        Comparator<Integer> comparator = (a, b) -> a % 10 > b % 10 ? 1 : -1;

        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(100);

        Collections.sort(nums, comparator);

        System.out.println(nums);
    }
}
