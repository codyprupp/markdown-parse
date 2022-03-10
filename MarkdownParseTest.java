import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void snippet1Test()
    {
        List<String> expected = List.of("%60google.com", "google.com", "ucsd.edu");
        List<String> actual = MarkdownParse.getLinks("snippet1.md");
        assertEquals(expected, actual);
    }

    @Test
    public void snippet2Test()
    {
        List<String> expected = List.of("a.com", "a.com(())", "example.com");
        List<String> actual = MarkdownParse.getLinks("snippet2.md");
        assertEquals(expected, actual);
    }

    @Test
    public void snippet3Test()
    {
        List<String> expected = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        List<String> actual = MarkdownParse.getLinks("snippet3.md");
        assertEquals(expected, actual);
    }
}