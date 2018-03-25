package idv.kuma._6kyu.word_a10n_abbreviation;

import static org.junit.Assert.*;
import org.junit.Test;

public class AbbreviatorTest {

    private Abbreviator abbr = new Abbreviator();

    @Test
    public void testInternationalization() {
        assertEquals("i18n", abbr.abbreviate("internationalization"));
    }

    @Test
    public void testCat() {
        assertEquals("cat", abbr.abbreviate("cat"));
    }

    @Test
    public void testKuma() {
        assertEquals("K2a", abbr.abbreviate("Kuma"));
    }

    @Test
    public void testKumab() {
        assertEquals("K3b", abbr.abbreviate("Kumab"));
    }

    @Test
    public void testKumaKuma() {
        assertEquals("K3b-ff l4l", abbr.abbreviate("Kumab-ff llooll"));
    }

}