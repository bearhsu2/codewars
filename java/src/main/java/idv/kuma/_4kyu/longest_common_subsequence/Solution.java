package idv.kuma._4kyu.longest_common_subsequence;

public class Solution {

    //https://en.wikipedia.org/wiki/Longest_common_subsequence_problem#First_property
    public static String lcs(String x, String y) {

        if (x.isEmpty() || y.isEmpty()) return "";

        char[] xChars = x.toCharArray();
        char[] yChars = y.toCharArray();

        return doFindLcs(xChars, yChars);
    }

    //

    static String doFindLcs(char[] xChars, char[] yChars) {
        int m = xChars.length;
        int n = yChars.length;
        int[][] table = new int[m + 1][n + 1];
        StringBuilder sb = new StringBuilder();

        // build table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (xChars[i - 1] == yChars[j - 1]) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        // back trace to retrieve sequence
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (xChars[i - 1] == yChars[j - 1]) {
                // Put current character in result
                sb.insert(0, xChars[i - 1]);

                // reduce values of i, j and index
                i--;
                j--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (table[i - 1][j] > table[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // return answer;
        return sb.toString();
    }

}