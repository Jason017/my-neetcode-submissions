class Solution {
    public boolean isAnagram(String s, String t) {
        int[] c1 = new int[256];
        int[] c2 = new int[256];

        for (char c : s.toCharArray()) {
            c1[c]++;
        }


        for (char c : t.toCharArray()) {
            c2[c]++;
        }

        for (int i = 0; i < 256; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
