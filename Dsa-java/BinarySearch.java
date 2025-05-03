public class BinarySearch {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};

        int target = 1;

        int result = binarySearch(nums, target);

        if (result == -1) {
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index " + result);
        }
    }

    private static int binarySearch(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }
}
