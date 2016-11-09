package org.fundacionjala.dashboard.ui.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.dashboard.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * This class support the remote connection to run execution.
 */
public abstract class RemoteService implements Driver {
    protected static final Logger LOGGER = LogManager.getLogger(RemoteService.class);

    protected static final Environment ENVIRONMENT = Environment.getInstance();

    protected static final String HTTPS_PROXY_HOST = "https.proxyHost";

    protected static final String HTTPS_PROXY_PORT = "https.proxyPort";

    protected static final String RESOLUTION = "screenResolution";

    /**
     * Configures the variables to execute remotely.
     * @return {@link DesiredCapabilities}
     */
    public abstract DesiredCapabilities setCapability();

    /**
     * Obtains the url of the remote executor.
     * @return the url in string format.
     */
    public abstract String getUrl();

    /**
     * {@inheritDoc}
     */
    public WebDriver initDriver() {
        String url = String.format(getUrl(), ENVIRONMENT.getRemoteUserName(),
                ENVIRONMENT.getRemoteKey());
        if (!ENVIRONMENT.getHost().isEmpty()) {
            System.getProperties().put(HTTPS_PROXY_HOST, ENVIRONMENT.getHost());
            System.getProperties().put(HTTPS_PROXY_PORT, ENVIRONMENT.getPort());
        }
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(url), setCapability());
        } catch (MalformedURLException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return remoteWebDriver;
    }
}
