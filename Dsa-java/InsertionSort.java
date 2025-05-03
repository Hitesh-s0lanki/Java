public class InsertionSort {
    public static void main(String[] args) {
        int nums[] = { 42, 7, 19, 85, 3, 66, 23, 90, 11, 58 };
        // int nums[] = { 1, 2 };

        insertionSort(nums);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    private static void insertionSort(int[] nums) {

        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int temp = nums[i];

            int j = i - 1;

            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = temp;
        }
    }
}
