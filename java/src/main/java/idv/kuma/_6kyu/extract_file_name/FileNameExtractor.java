package idv.kuma._6kyu.extract_file_name;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
public class FileNameExtractor {
    public static String extractFileName(String dirtyFileName) {

        int dateEnd = dirtyFileName.indexOf("_");

        String subString = dirtyFileName.substring(dateEnd + 1);

        int otherExtensionbegin = subString.lastIndexOf(".");

        String result = subString.substring(0, otherExtensionbegin);

        return result;
    }
}