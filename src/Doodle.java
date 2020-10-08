import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Doodle {
    public static String geRes(String url) {
        ReadPropertyFile config = new ReadPropertyFile();
        try {
            URLConnection con = (new URL(url)).openConnection();
            con.setRequestProperty("Cookie", config.getProperty("doodleCookie"));
            con.setRequestProperty("Host", "doodle.com");

            InputStream response = con.getInputStream();
            Scanner sc = new Scanner(response);
            String responseBody = sc.useDelimiter("\\A").next();
            return responseBody;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
