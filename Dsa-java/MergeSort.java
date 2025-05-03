public class MergeSort {
    public static void main(String[] args) {
        int nums[] = { 5, 3, 6, 1, 4, 2 };
        // int nums[] = { 1, 4, 2 };

        int n = nums.length;

        mergeSort(nums, 0, n - 1);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    private static void mergeSort(int[] nums, int start, int end) {

        if (start >= end)
            return;

        int mid = (start + end) / 2;

        // left side
        mergeSort(nums, start, mid);

        // right side
        mergeSort(nums, mid + 1, end);

        merge(nums, start, end);
    }

    private static void merge(int[] nums, int start, int end) {
        int mid = (start + end) / 2;

        int left = mid - start + 1;
        int right = end - mid;

        int[] leftArray = new int[left];
        int[] rightArray = new int[right];

        // copy values
        for (int i = 0; i < left; i++) {
            leftArray[i] = nums[start + i];
        }

        for (int i = 0; i < right; i++) {
            rightArray[i] = nums[mid + i + 1];
        }

        // merge logic
        int i = 0;
        int j = 0;
        int k = start;

        while (i < left && j < right) {
            if (leftArray[i] < rightArray[j]) {
                nums[k] = leftArray[i++];
            } else {
                nums[k] = rightArray[j++];
            }
            k++;
        }

        while (i < left) {
            nums[k] = leftArray[i++];
            k++;
        }

        while (j < right) {
            nums[k] = rightArray[j++];
            k++;
        }

    }
}
