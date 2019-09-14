package idv.kuma._6kyu.diamond;

class Diamond {
    public static String print(int n) {
        // TODO your code here
        if (0 >= n || 0 == n % 2) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // upper diamond
        for (int i = 1; i <= n; i += 2) {
            appendChars(sb, n, i);
        }

        // lower diamond
        for (int i = n - 2; i >= 1; i -= 2) {
            appendChars(sb, n, i);

        }


        return sb.toString();
    }

    private static void appendChars(StringBuilder sb, int n, int i) {
        for (int j = 0; j < (n - i) / 2; j++) {
            sb.append(" ");
        }
        for (int j = 0; j < i; j++) {
            sb.append("*");
        }
        sb.append("\n");
    }
}