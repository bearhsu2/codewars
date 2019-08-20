package idv.kuma._6kyu.decode_thie_morse_code;

public class MorseCodeDecoder {

    // https://www.codewars.com/kata/decode-the-morse-code/train/java

    public static String decode(String encodedFull) {

        encodedFull = trim(encodedFull);

        print(encodedFull, "Full");

        String[] encodedWords = encodedFull.split("   ");

        StringBuilder sb = new StringBuilder();
        for (String encodedWord : encodedWords) {

            print(encodedWord, "word");

            String[] encodedLetters = encodedWord.split(" ");

            for (String encodedLetter : encodedLetters) {
                print(encodedLetter, "letter");

                sb.append(MorseCode.get(encodedLetter));

            }

            sb.append(" ");

        }

        return trim(sb.toString());
    }

    static String trim(String encodedFull) {
        return encodedFull.trim();
    }

    static void print(String encoded, String title) {
        System.out.println(title + " = ###" + encoded + "###");
    }
}
