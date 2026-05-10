class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> h1 = createFrequencyMap(s);
        HashMap<Character, Integer> h2 = createFrequencyMap(t);
        return h1.equals(h2);
    }

    private HashMap<Character, Integer> createFrequencyMap(String s) {
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character item = s.charAt(i);
            Integer currentCount = hashMap.getOrDefault(item, 0);
            hashMap.put(item, currentCount + 1);
        }
        return hashMap;
    }
}
