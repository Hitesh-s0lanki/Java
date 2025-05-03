public class BubbleSort {
    public static void main(String[] args) {
        int nums[] = { 42, 7, 19, 85, 3, 66, 23, 90, 11, 58 };

        bubbleSort(nums);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    private static void bubbleSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean needSort = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    needSort = true;
                }
            }
            if (!needSort)
                return;
        }

    }
}
