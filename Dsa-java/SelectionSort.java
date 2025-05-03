public class SelectionSort {
    public static void main(String[] args) {
        int nums[] = { 42, 7, 19, 85, 3, 66, 23, 90, 11, 58 };

        selectionSort(nums);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    private static void selectionSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = 0;
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = nums[n - i - 1];
            nums[n - i - 1] = nums[maxIndex];
            nums[maxIndex] = temp;
        }

    }
}
