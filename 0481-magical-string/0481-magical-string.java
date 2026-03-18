class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] s = new int[n];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int countOnes = 1;
        int i = 2;   
        int j = 3;   
        int next = 1;

        while (j < n) {
            int freq = s[i];

            for (int k = 0; k < freq && j < n; k++) {
                s[j] = next;
                if (next == 1) countOnes++;
                j++;
            }

            next = (next == 1) ? 2 : 1;
            i++;
        }

        return countOnes;
    }
}