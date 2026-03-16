class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder first = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                first.append(c);
            } 
            else if (c == ')') {
                if (open > 0) {
                    open--;
                    first.append(c);
                }
            } 
            else {
                first.append(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = first.length() - 1; i >= 0; i--) {
            char c = first.charAt(i);
            if (c == '(' && open-- > 0) continue;
            res.append(c);
        }

        return res.reverse().toString();
    }
}