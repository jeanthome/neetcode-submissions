class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> indexMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                res[0] = indexMap.get(complement);
                res[1] = i;
                break;
            }

            indexMap.put(nums[i], i);
        }
        return res;
    }
}
