package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.List;

public class LyricsTest extends BaseTest {

    @Test
    public void test99BottlesSongLyrics() {
        final String expectedSongLyrics = TestUtils.createSongLyrics();

        List<String> songLyrics = openBaseURL()
                        .clickSongLyricsSubmenu()
                        .getSongLyrics();

        StringBuilder actualSongLyrics = new StringBuilder();
        for(String text : songLyrics) {
            actualSongLyrics.append(text);
        }

        Assert.assertEquals(actualSongLyrics.toString(),expectedSongLyrics);
    }
}
