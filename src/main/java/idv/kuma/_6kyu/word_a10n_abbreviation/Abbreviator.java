package idv.kuma._6kyu.word_a10n_abbreviation;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
public class Abbreviator {

    public String abbreviate(String string) {

        if (string == "") {
            return string;
        }

        char[] chars = string.toCharArray();
        int length = chars.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {

            char c = chars[i];
            if (Character.isLetter(c)) {
                // find next non-letter
                int j = i;
                for (; j < length; j++) {
                    if (!Character.isLetter(chars[j])) {
                        break;
                    }
                }

                if (j - i > 3) {
                    sb.append(chars[i]);
                    sb.append(j - i - 2);
                    sb.append(chars[j - 1]);
                } else {
                    sb.append(string.substring(i, j));
                }

                i = j - 1;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}