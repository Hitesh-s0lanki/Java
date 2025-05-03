public class QuickSort {

    public static void main(String[] args) {
        // int nums[] = { 42, 7, 19, 85, 3, 66, 23, 90, 11, 58 };
        int nums[] = { 5, 3, 6, 1, 4, 2 };

        int n = nums.length;

        quickSort(nums, 0, n - 1);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    private static void quickSort(int[] nums, int start, int end) {

        if (start >= end)
            return;

        int pivot = partition(nums, start, end);

        // left side
        quickSort(nums, start, pivot - 1);

        // right side
        quickSort(nums, pivot + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];

        int i = start - 1;
        int j = start;

        while (j < end) {

            if (nums[j] < pivot) {

                i = i + 1;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }

            j++;
        }

        int temp = nums[i + 1];
        nums[i + 1] = pivot;
        nums[end] = temp;

        return i + 1;

    }
}
