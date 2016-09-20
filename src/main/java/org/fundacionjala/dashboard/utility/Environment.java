package org.fundacionjala.dashboard.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is in charge to set the default  parameters to
 * establishes the connection with pivotal tracker.
 */
public final class Environment {

    private static final String CONFIG = "gradle.properties";

    //private static final Logger LOGGER = Logger.getLogger(Environment.class);

    private static final String AUTHENTICATION_TOKEN = "token";

    private static final String AUTHENTICATION_PROXY = "authentication.proxy";

    private static final String AUTHENTICATION_BASE_URI = "authentication.baseURI";

    private static final String TIMEOUT = "timeout";

    private static final String BROWSER = "browser";

    private static Environment environment;

    private Properties properties;

    /**
     * This method read the config property file.
     */
    private Environment() {
        File file = new File(CONFIG);
        try (FileReader fileReader = new FileReader(file)) {
            properties = new Properties();
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("The properties file couldn't be found");
            //LOGGER.warn("The properties file couldn't be found", e);
        } catch (IOException e) {
            System.out.println("A problem of type");
            //LOGGER.warn("A problem of type", e);
        }
    }

    /**
     * This method Instance the environment if this does not exist.
     *
     * @return the instanced Environment.
     */
    public static Environment getInstance() {

        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    /**
     * Get the properties of the file.
     *
     * @param env string name of property setting.
     * @return String that is a property
     */
    public String getEnv(final String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return properties.getProperty(env);
        }
        return property;
    }

    /**
     * Get the base url of pivotal tracker.
     *
     * @return String url.
     */
    public String getBaseUri() {
        return getEnv(AUTHENTICATION_BASE_URI);
    }

    /**
     * Get the proxy.
     *
     * @return String with the configured proxy.
     */
    public String getProxy() {
        return getEnv(AUTHENTICATION_PROXY);
    }

    /**
     * Get the configured token.
     *
     * @return String with the configured token.
     */
    public String getToken() {
        return getEnv(AUTHENTICATION_TOKEN);
    }

    /**
     * Get the timeout.
     * @return String with the configure timeout.
     */
    public int getTimeout() {
        return Integer.parseInt(getEnv(TIMEOUT));
    }

    /**
     * Get the timeout.
     * @return String with the configure timeout.
     */
    public String getBrowser() {
        return getEnv(BROWSER);
    }
}
