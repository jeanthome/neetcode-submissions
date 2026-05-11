class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagramMap = new HashMap();

        for (String s: strs) {
            String key = this.getAnagramOrNull(anagramMap.keySet(), s);

            if (key == null) {
                anagramMap.put(s, new ArrayList<>(List.of(s)));
            } else {
                anagramMap.get(key).add(s);
            }
        }
        return new ArrayList<List<String>>(anagramMap.values());   
    }

    private String getAnagramOrNull(Set<String> keySet, String candidate) {
        for (String key: keySet) {
            if (isAnagram(candidate, key)) return key;
        }
        return null;
    }

    private boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < first.length(); i++) {
            count[first.charAt(i) - 'a']++;
            count[second.charAt(i) - 'a']--;
        }

        for (int num : count) {
            if (num != 0) return false;
        }

        return true;
    }
}
