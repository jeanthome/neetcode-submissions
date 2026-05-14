class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                output[0] = left + 1;
                output[1] = right + 1;
                return output;
            }
        }

        return output;
    }
}
