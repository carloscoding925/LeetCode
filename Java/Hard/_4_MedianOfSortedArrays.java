package Java.Hard;

public class _4_MedianOfSortedArrays {
    public static void main(String args[]) {
        System.out.println("#4 - Median of Two Sorted Arrays - Hard");

        int[] listOne = {1, 2};
        int[] listTwo = {3, 4};

        double median = findMedianSortedArrays(listOne, listTwo);

        System.out.println("Median of sorted arrays: " + median);

        return;
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean isEven = length % 2 == 0;
        boolean isFirstArray = false;

        int firstPointer = 0;
        int secondPointer = 0;

        for (int i = 0; i < length / 2; i++) {
            int firstVal = nums1[firstPointer];
            int secondVal = nums2[secondPointer];

            if (firstVal > secondVal) {
                isFirstArray = true;
                secondPointer++;
            }
            else if (secondVal > firstVal) {
                isFirstArray = false;
                firstPointer++;
            }
            else {
                firstPointer++;
                secondPointer++;
            }
        }

        int median;
        if (isFirstArray) {
            median = nums1[firstPointer];
        }
        else {
            median = nums2[secondPointer];
        }

        if (isEven) {
            if (isFirstArray) {
                median = nums1[firstPointer];
            }
            else {
                median = nums2[secondPointer];
            }
        }

        return median;
    }
}
