class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<List<Integer>> itemsByFreq = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) itemsByFreq.add(null);

        for (Integer num : nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }

        for (Integer num : freqMap.keySet()) {
            Integer freq = freqMap.get(num);
            if (itemsByFreq.get(freq) == null) {
               itemsByFreq.set(freq, new ArrayList<Integer>());
            }
             itemsByFreq.get(freq).add(num);
        }

        for (int i = itemsByFreq.size() - 1; i > 0; i--) {
            if (itemsByFreq.get(i) == null) continue;
            for (Integer num: itemsByFreq.get(i)) {
                output.add(num);

                if (output.size() == k) {
                    return output.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }

        return new int[2];
    }
}
