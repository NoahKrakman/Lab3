import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }


    public static void main(String[] unused) {
        String text = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        int wordCount = 0;
        String[] arrayOfString = text.split(" ");
        String wordToCheck = "and";
        for (int index = 0; index < arrayOfString.length; index++) {
            if (arrayOfString[index].equals(wordToCheck)) {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
}
