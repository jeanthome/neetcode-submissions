class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0, left = 0, right = heights.length - 1;

        while (left < right) {
            int currentArea = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, currentArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
