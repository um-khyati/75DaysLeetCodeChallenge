class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];

        for (char c : s.toCharArray()) countS[c - 'a']++;
        for (char c : t.toCharArray()) countT[c - 'a']++;

        return Arrays.equals(countS, countT);

    }
}