package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class Props {
    private static Properties environmentProps;

    /**
     * Gets the key from messages.properties for a Site
     *
     * @param key
     **/
    public static String getMessage(String key) {

        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return ResourceBundle.getBundle("props/messages").getString(key);

        }
    }

    /**
     * Gets the key from Config.properties related to chosen profile
     *
     * @param key
     **/

    public static String getProp(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            if (environmentProps == null) {
                loadRunConfigProps("/automation.yml");
            }
            return environmentProps.getProperty(key);
        }
    }

    public static void loadRunConfigProps(String configPropertyFileLocation) {
        if (environmentProps == null) {
            environmentProps = new Properties();
            try (InputStream inputStream = Props.class.getResourceAsStream(configPropertyFileLocation)) {
                environmentProps.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}