package core;

import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
    private static final String URL = "url";
    private static final String BROWSER = "browser";
    private static final String HEADLESS = "headless";
    private static final String TIMEOUT = "timeout";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static ReadProperties instance;
    static Properties properties;

    public ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }
    public String getURL() {
        return properties.getProperty(URL);
    }
    public String getUsername(){
        return properties.getProperty(USERNAME);
    }
    public String getPassword(){
        return properties.getProperty(PASSWORD);
    }
    public String getBrowserName() {
        return properties.getProperty(BROWSER);
    }
    public boolean isHeadless() {
        return properties.getProperty(HEADLESS).equalsIgnoreCase("true");
    }
    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty(TIMEOUT));
    }
}

