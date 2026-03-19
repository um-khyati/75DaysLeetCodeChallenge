class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(String s, int index, int parts, List<String> curr, List<String> res) {
        if (parts == 4 && index == s.length()) {
            res.add(String.join(".", curr));
            return;
        }
        
        // Invalid cases
        if (parts == 4 || index == s.length()) return;
        
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            
            if (isValid(part)) {
                curr.add(part);
                backtrack(s, index + len, parts + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}