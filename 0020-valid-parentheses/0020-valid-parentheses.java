import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if((len & 1) == 1) return false;

        char[] stck = new char[len];
        int top = 0;

        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            switch(ch){
                case '(': stck[top++] = ')'; break;
                case '[': stck[top++] = ']'; break;
                case '{': stck[top++] = '}'; break;
                default:
                    if(top == 0 || stck[--top] != ch) return false;
            }
        }
        return top == 0;
    }
}