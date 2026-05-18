class Solution {
    public int trap(int[] height) {
        int maxArea = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j]);
            maxRight[j] = Math.min(maxRight[j], maxLeft[j]);
        }

        for (int i = 0; i < height.length; i++) {
            maxArea += maxRight[i] - height[i];
        }

        return maxArea;
    }
}
