class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.addAll(List.of("+", "-", "*", "/"));
        for (String s : tokens) {
            if (!operators.contains(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                Integer right = stack.pop(), left = stack.pop();
                if (s.equals("+")) {
                    stack.push(left + right);
                } else if ( s.equals("-")) {
                    stack.push(left - right);
                } else if ( s.equals("*")) {
                    stack.push(left * right);
                } else {
                    stack.push(left / right);
                }
            }
        }
        return stack.pop();
    }
}
