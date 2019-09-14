package idv.kuma._6kyu.extract_file_name;

import static org.junit.Assert.*;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class FileNameExtractorTest {
    @Test
    public void testSample() {
        assertEquals(
                "FILE_NAME.EXTENSION",
                FileNameExtractor.extractFileName("1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION")
        );
        assertEquals(
                "FILE_NAME.EXTENSION",
                FileNameExtractor.extractFileName("1_FILE_NAME.EXTENSION.OTHEREXTENSIONadasdassdassds34")
        );
    }
}