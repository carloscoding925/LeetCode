package Java.Medium;

public class _11_ContainerWithWater {
    public static void main(String[] args) {
        System.out.println("#11 - Container With Most Water - Medium");

        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = maxArea(input);

        System.out.println("Max Area: " + area);

        return;
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentArea = width * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}
