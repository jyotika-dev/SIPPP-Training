// https://www.geeksforgeeks.org/problems/search-pattern0205/1 

class SearchPattern {

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int[] lps = computeLPSArray(pat, M);
        int i = 0; // index for txt
        int j = 0; // index for pat
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                return i - j; // found pattern at index (i - j)
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // pattern not found
    }

    private static int[] computeLPSArray(String pat, int M) {
        int[] lps = new int[M];
        int len = 0; // length of previous longest prefix suffix
        lps[0] = 0; // lps[0] is always 0
        int i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
