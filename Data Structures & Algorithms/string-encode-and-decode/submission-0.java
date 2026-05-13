class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String str : strs) {
            builder.append(str.length()).append("#").append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int index = 0;
        
        while (index < str.length()) {
            StringBuilder sizeBuilder = new StringBuilder();
            while (str.charAt(index) != '#') {
                sizeBuilder.append(String.valueOf(str.charAt(index++))); 
            }
            index++;
            Integer size = Integer.valueOf(sizeBuilder.toString());
            output.add(str.substring(index, index + size));
            index+=size;
        }
        return output;
    }
}
