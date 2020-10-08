import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {
    private Properties prop;
    public ReadPropertyFile() {
        this.prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("config.properties");
            prop.load(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String propName) {
        return this.prop.getProperty(propName);
    }
}
