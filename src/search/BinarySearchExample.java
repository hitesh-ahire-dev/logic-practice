package search;

public class BinarySearchExample {
    public static int binarySearch(int[] arr, int target){
        int first = 0;
        int last = arr.length;
        int mid = 0;

        while (first <= last){
             mid = (first + last) / 2;

            if (arr[mid] == target){
                return mid;
            }else if(target > arr[mid]){
                first = mid + 1;
            }else {
                last = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 10, 12, 14};

        int index = binarySearch(nums, 10);

        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not found");
        }
    }
}
